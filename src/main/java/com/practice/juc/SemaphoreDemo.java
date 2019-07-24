package com.practice.juc;

import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//3个车位 即3个资源
        for (int i = 1; i <=6; i++) {//6辆车抢三个车位  即6个线程
            new Thread(i+""){
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//没抢到则阻塞在这里，抢到资源则往下走
                        System.out.println(Thread.currentThread().getName()+" 抢到车位");
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName()+" 停车3s后离开车位");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();//释放资源
                    }
                }
            }.start();
        }
    }
}
