package com.practice.juc;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorConsumer_Lock {
    public static void main(String[] args) {
           Resource resource = new Resource("面包");
           Productor productor = new Productor(resource);
           Consumer consumer = new Consumer(resource);

           Thread t1 = new Thread(productor,"师傅A");
           Thread t2 = new Thread(productor,"师傅B");
           Thread t3 = new Thread(consumer,"学生1");
           Thread t4 = new Thread(consumer,"学生2");
           Thread t5 = new Thread(consumer,"学生3");
           t1.start();
           t2.start();
           t3.start();
           t4.start();
           t5.start();



    }
}

class Productor implements Runnable{
    Resource resource = null;

    public Productor(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        //生产者生产10次
        for (int i = 0; i <15 ; i++) {
            resource.set();
        }
    }
}

class Consumer implements Runnable{
    Resource resource = null;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        //生产者生产10次
        for (int i = 0; i <10 ; i++) {
            resource.out();
        }
    }
}

class Resource{
    String name;
     int num = 0;
     boolean flag = false;
    Lock lock = new ReentrantLock();
    Condition product_condition = lock.newCondition();//生产者监视器
    Condition consumer_condition = lock.newCondition();//消费者监视器
    public void set(){
        try {
            lock.lock();
            while(flag){//flag为true则说明 有资源可以消费不用去生产
                product_condition.await();//生产者挂起
            }
            num++;
            System.out.println(Thread.currentThread().getName()+" 生产了"+name+num);

            flag = !flag;
            consumer_condition.signalAll();//唤醒消费者
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void out(){
        try {
            lock.lock();
            while(!flag){//flag为false则说明没有资源可以消费
                consumer_condition.await();//消费者挂起
            }
            System.out.println(Thread.currentThread().getName()+" 消费了"+name+num);
            flag = !flag;
            product_condition.signalAll();//唤醒生产者
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public Resource(String name) {
        this.name = name;
    }
}

