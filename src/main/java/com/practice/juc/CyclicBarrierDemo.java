package com.practice.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("5人都到齐了，大家开始开会。。。");
            }
        });

        for (int i = 0; i <5 ; i++) {
            new Thread(i+""){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"到了，等待人全都到齐");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
