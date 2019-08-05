package com.practice.jvm;


import com.practice.innerclass.OutClass;

public class HelloGC extends OutClass{
    public static void main(String[] args) {

        System.out.println("**************hello GC*****************");
        byte[] bytes = new byte[20*1024*1024];
    }
}
