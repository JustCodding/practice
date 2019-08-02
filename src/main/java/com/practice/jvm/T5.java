package com.practice.jvm;

public class T5 {
    static int count = 0;
    static void r(){
        count++;
        System.out.println("count:"+count);
        r();
    }
    public static void main(String[] args) {
           try {
                r();
           }catch (Throwable t){
               System.out.println("count:"+count);
                t.printStackTrace();
           }
    }
}
