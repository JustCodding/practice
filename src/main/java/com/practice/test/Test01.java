package com.practice.test;

public class Test01 {
   public static void main(String[] args) {
       long total_memory = Runtime.getRuntime().totalMemory();
       long max_memory = Runtime.getRuntime().maxMemory();
       System.out.println("Xms:"+total_memory/(1024*1024)+"m");
       System.out.println("Xmx:"+max_memory/(1024*1024)+"m");
   }
}
