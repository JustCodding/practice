package com.practice.reference;
import java.lang.ref.SoftReference;
public class SoftReferenceDemo {
    public static void main(String[] args) {
        //softReference_memory_enough();
        softReference_memory_not_enough();
    }
    /*
    内存足够时，垃圾回收 并不会回收obj2对new Object()的软引用，
    也就是不会回收new Object()在堆中的对象
    */
    public static  void softReference_memory_enough(){
        Object obj1 = new Object();
        SoftReference<Object> obj2 = new SoftReference<Object>(obj1);

        System.out.println(obj1);
        System.out.println(obj2.get());

        obj1 = null;
        System.gc();

        System.out.println(obj1);
        System.out.println(obj2.get());
    }

    /*
    设置堆内存为10M -Xms10m -Xmx10m -XX:+PrintGCDetails
    内存不够时会回收obj2对new Object()的软引用，也就是会回收
    new Object()在堆中的对象
    */
    public static  void softReference_memory_not_enough(){
        Object obj1 = new Object();
        SoftReference<Object> obj2 = new SoftReference<Object>(obj1);

        System.out.println(obj1);
        System.out.println(obj2.get());

        obj1 = null;

        try {
              //在堆区中开辟20M内存，内存不够时会自动进行一次gc
              byte[] bytes = new byte[20*1024*1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(obj1);
            System.out.println(obj2.get());
        }

    }


}
