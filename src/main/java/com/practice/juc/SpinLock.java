package com.practice.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SpinLock {
    //new AtomicInteger()的初始值是0，原子引用初始值则是null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void Lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"  开始获取自旋锁");
        /*
            如果atomicReference中的值期待值不为null，则线程在此循环判断期待值是否为null
            相当于没有获取到锁，线程"阻塞"，但是相比于java提供的锁，这里并不是真正的线程阻塞，
            而是在循环的普安段，直到期待值为null,则线程可以跳出循环，继续往下执行，相当于获得了锁
         */
        while(!atomicReference.compareAndSet(null,thread)){
        }
        System.out.println(thread.getName()+"  获取到了自旋锁");

    }
    //执行Lock()之后，必须执行unLock()进行释放锁，否则其他线程没法获取到锁该锁了
    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"  释放了自旋锁");
    }

    public static void main(String[] args) {

        final SpinLock spinLock = new SpinLock();
        new Thread("AA"){
            @Override
            public void run() {
                //同步代码块
                spinLock.Lock();
                System.out.println(Thread.currentThread().getName()+"线程 同步代码块执行");
                spinLock.unLock();
            }
        }.start();


        new Thread("BB"){
            @Override
            public void run() {
                //同步代码块
                spinLock.Lock();
                System.out.println(Thread.currentThread().getName()+"线程 同步代码块执行");
                spinLock.unLock();
            }
        }.start();
    }
}
