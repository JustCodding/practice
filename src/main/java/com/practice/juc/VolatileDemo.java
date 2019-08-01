package com.practice.juc;

import java.util.concurrent.atomic.AtomicInteger;

class Mydata{
    //volatile可以保证可见性 但是不能保证原子性
    volatile int number = 0;
    //怎么保证原子性呢? 1.给addPlusPlus给同步锁,这个耗资源 2.使用AtomicInteger
    AtomicInteger atomicInteger = new AtomicInteger();

    void addTo60(){
        number = 60;
    }

    void addPlusPlus(){
        number++;
    }

    void atomicAddPlusPlus(){
        atomicInteger.getAndIncrement();
    }

}

public class VolatileDemo {
    public static void main(String[] args) {
        final Mydata mydata = new Mydata();
        for (int i = 0; i < 20; i++) {
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        mydata.addPlusPlus();
                        mydata.atomicAddPlusPlus();
                    }
                }
            }.start();
        }

        //等待上面所有线程计算完 主线程+gc线程
        while(Thread.activeCount()>2){
            Thread.yield();//礼让  cpu你去执行别的线程吧 哈哈
        }
        System.out.println("int number:"+mydata.number);
        System.out.println("atomicinteger number:"+mydata.atomicInteger);
    }


    //volatile 保证可见性
    public static void seeok(){
        final Mydata mydata = new Mydata();
        new Thread("AA"){
            @Override
            public void run() {
                System.out.println("线程:"+Thread.currentThread().getName()+" come in");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mydata.addTo60();
                System.out.println("线程:"+Thread.currentThread().getName()+" update num:"+mydata.number);
            }
        }.start();

        while(mydata.number==0){
            //如果numer为0 则一直循环等待，直到number的值不为0才结束循环
        }

        System.out.println("主线程main 获取到最新的num:"+mydata.number);
    }

}


