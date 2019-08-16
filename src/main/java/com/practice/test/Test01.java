package com.practice.test;

public class Test01 {
   public static void main(String[] args) {
      ThreadLocal<String> threadLocal = new ThreadLocal<>();
      threadLocal.set("cjp");

   }
}
