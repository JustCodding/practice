package com.practice.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(i+""){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"同学离开教室");
                    countDownLatch.countDown();
                }
            }.start();
        }

        countDownLatch.await();
        System.out.println("班长最后锁门");
    }
}
