package com.practice.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCahce cahce = new MyCahce();
        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(i+""){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"--开始写入数据");
                    cahce.put(num+"",num);
                    System.out.println(Thread.currentThread().getName()+"--写入数据完成");
                }
            }.start();
        }

        for (int i = 0; i <5 ; i++) {
            final int num = i;
            new Thread(i+""){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"--开始读数据");
                    cahce.get(num+"");
                    System.out.println(Thread.currentThread().getName()+"--读数据完成");
                }
            }.start();
        }

    }
}


class MyCahce{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        reentrantReadWriteLock.writeLock().lock();
        map.put(key,value);
        reentrantReadWriteLock.writeLock().unlock();
    }

    public Object get(String key){
        reentrantReadWriteLock.readLock().lock();
        Object result = map.get(key);
        reentrantReadWriteLock.readLock().unlock();
        return result;
    }

}
