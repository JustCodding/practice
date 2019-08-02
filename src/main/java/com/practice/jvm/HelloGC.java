package com.practice.jvm;


import com.practice.innerclass.OutClass;

public class HelloGC extends OutClass{
    public static void main(String[] args) {

        System.out.println("**************hello GC*****************");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
