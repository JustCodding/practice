package com.practice.jvm;

public class Test02 {
    public static void main(String[] args) {
    long totalMemory = Runtime.getRuntime().totalMemory();
    long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(totalMemory/(1024*1024)+"M");
        System.out.println(maxMemory/(1024*1024)+"M");
    }
}
