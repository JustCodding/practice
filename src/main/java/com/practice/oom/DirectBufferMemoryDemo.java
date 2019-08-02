package com.practice.oom;

import sun.misc.VM;

import java.nio.ByteBuffer;

public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        //获取可用的最大的直接内存 默认是系统内存的1/4，可以通过参数调整大小
        System.out.println("max direct memory:"+ VM.maxDirectMemory()/(1024*1024)+"M");
        //设置最大直接内存为5m,-XX:MaxDirectMemorySize=5m,然后申请6m的直接内存
        ByteBuffer.allocateDirect(6*1024*1024);
    }
}
