package com.practice.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        /*
            模拟10个用户线程请求，5个线程窗口办理业务
        * */
        //ExecutorService ThreadPool = Executors.newFixedThreadPool(5);
        //ExecutorService ThreadPool = Executors.newSingleThreadExecutor();
        ExecutorService ThreadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10; i++) {
                ThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                    }
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ThreadPool.shutdown();//线程池关闭
        }
    }
}
