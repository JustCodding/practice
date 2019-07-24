package com.practice.juc;
/*
* 要求A B C三个线程 先A打印1-5 接着B打印1-10 接着C打印1-15
* 再接着A打印1-5,接着B打印1-10 接着C打印1-15,如此循环5次
* */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Conditions {
    public static void main(String[] args) {
           ShareData shareData = new ShareData();
           new Thread("A"){
               @Override
               public void run() {
                   for (int i = 0; i <3 ; i++) {
                       shareData.print();
                   }
               }
           }.start();
        new Thread("B"){
            @Override
            public void run() {
                for (int i = 0; i <3 ; i++) {
                    shareData.print();
                }
            }
        }.start();
        new Thread("C"){
            @Override
            public void run() {
                for (int i = 0; i <3 ; i++) {
                    shareData.print();
                }
            }
        }.start();
    }
}

class ShareData{
    int num = 1;
    Lock lock = new ReentrantLock();
    Condition condition_a = lock.newCondition();
    Condition condition_b = lock.newCondition();
    Condition condition_c = lock.newCondition();
    public void print(){
        lock.lock();
        try {
            String name = Thread.currentThread().getName();
            if(name.equals("A")){
                while (num!=1){
                    condition_a.await();
                }
                for (int i = 1; i <=5; i++) {
                    System.out.println(name+" "+i);
                }
                num=2;
                condition_b.signal();
            }
            if(name.equals("B")){
                while (num!=2){
                    condition_b.await();
                }
                for (int i = 1; i <=10; i++) {
                    System.out.println(name+" "+i);
                }
                num=3;
                condition_c.signal();
            }
            if(name.equals("C")){
                while (num!=3){
                    condition_c.await();
                }
                for (int i = 1; i <=15; i++) {
                    System.out.println(name+" "+i);
                }
                num=1;
                condition_a.signal();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

