package com.practice.juc;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //threadPoolInit();
        ExecutorService ThreadPool = new ThreadPoolExecutor(
                2,
                5,
                1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
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

    private static void threadPoolInit() {
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
