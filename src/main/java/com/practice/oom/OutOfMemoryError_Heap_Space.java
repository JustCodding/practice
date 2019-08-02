package com.practice.oom;

public class OutOfMemoryError_Heap_Space {
    public static void main(String[] args) {
        byte[] bytes = new byte[20*1024*1024];
    }
}
