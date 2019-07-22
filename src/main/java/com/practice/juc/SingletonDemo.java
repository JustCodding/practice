package com.practice.juc;

public class SingletonDemo {
    //这里volatile的作用主要是禁止指令重排
    private static volatile SingletonDemo singleton = null;
    private SingletonDemo(){//构造函数私有化
        System.out.println(Thread.currentThread().getName()+" init SingletonDemo");
    }
    //DCL double check lock双端检索机制
    public static SingletonDemo getInstace(){
        if(singleton==null){
            synchronized (SingletonDemo.class){
                if(singleton==null){
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

    }
}
