package com.practice.jvm;

public class T3 {
    public static void main(String[] args) {
        printMemoryInfo();
        byte[] b = new byte[1024*1024];
        printMemoryInfo();
    }
    static void printMemoryInfo(){
        System.out.println("total:"+Runtime.getRuntime().totalMemory());
        System.out.println("free:"+Runtime.getRuntime().freeMemory());
    }
}
