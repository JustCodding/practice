package com.practice.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        final BlockingQueue<String>  queue = new SynchronousQueue<>();
        new Thread("AAA"){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"\t put a");
                    queue.put("a");//同步队列put之后就会阻塞，直到take之后才能往下走
                    System.out.println(Thread.currentThread().getName()+"\t put b");
                    queue.put("b");
                    System.out.println(Thread.currentThread().getName()+"\t put c");
                    queue.put("c");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("BBB"){
            @Override
            public void run() {
                try {
                   Thread.sleep(2000);
                   System.out.println(queue.take());
                   Thread.sleep(2000);
                    System.out.println(queue.take());
                    Thread.sleep(2000);
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
