package com.practice.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyTask());
        Thread thread = new Thread(futureTask,"AA");
        thread.start();
        System.out.println("result:"+futureTask.get());
    }
}

class MyTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("+++++++++++come in++++++++++");
        return 1024;
    }
}
