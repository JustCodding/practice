package com.practice.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductorConsumer_BlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
        Myresource myresource = new Myresource(blockingQueue);
        new Thread("productor"){
            @Override
            public void run() {
                System.out.println("生产者线程启动。。。");
                myresource.prod();
            }
        }.start();
        new Thread("consumer"){
            @Override
            public void run() {
                System.out.println("消费者线程启动。。。");
                myresource.consume();
            }
        }.start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5s时间到 boss叫停生产活动");
        myresource.stop();
    }
}


class Myresource{
    volatile boolean flag = true;//默认true 表示生产和消费活动开始
    BlockingQueue<String> blockingQueue = null;
    AtomicInteger atomicInteger = new AtomicInteger();

    public Myresource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        //输出传入队列的具体类型
        System.out.println(blockingQueue.getClass().getName());
    }

    public void prod(){
        String data = null;
        boolean success;
        while (flag){
            try {
                data = atomicInteger.incrementAndGet()+"";
                success = blockingQueue.offer(data,2, TimeUnit.SECONDS);
                if (success) {
                    System.out.println(Thread.currentThread().getName()+" 插入队列数据:"+data+" 成功");
                }else{
                    System.out.println(Thread.currentThread().getName()+" 插入队列数据:"+data+" 失败");
                }
                Thread.sleep(1000);//1s钟生产一个

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("boss 叫停，"+Thread.currentThread().getName() + "\t 停止生产，flag=" + flag);
    }
    public void consume(){
        String result = null;
        while (flag){
            try {
                result = blockingQueue.poll(2,TimeUnit.SECONDS);
                if(result == null){
                    flag=false;
                    System.out.println(Thread.currentThread().getName()+"\t"+"超过2m没有取到 消费退出");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "消费队列数据:" + result + "成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void stop(){
        flag = false;
    }

}