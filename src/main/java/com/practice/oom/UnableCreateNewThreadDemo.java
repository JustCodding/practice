package com.practice.oom;

public class UnableCreateNewThreadDemo {
    //这个代码千万不要在windwos环境运行，不然系统卡死
    //在linux下 javac UnableCreateNewThreadDemo.java；java  com.practice.oom.UnableCreateNewThreadDemo
    public static void main(String[] args) {
            for (int i=1;;i++){//不断的创建线程
                System.out.println("*********:"+i);
                new Thread(i+""){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(60*1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
    }
}
