package com.practice.jvm;
public class Test01 {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println("******:"+obj.getClass().getClassLoader());
        Test01 test01 = new Test01();
        System.out.println("******:"+test01.getClass().getClassLoader());
        System.out.println("******:"+test01.getClass().getClassLoader().getParent());
        System.out.println("******:"+test01.getClass().getClassLoader().getParent().getParent());
    }
}
