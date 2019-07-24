package com.practice.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
        public static void main(String[] args) throws InterruptedException {
            BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
            System.out.println(queue.offer("aa", 2, TimeUnit.SECONDS));
            System.out.println(queue.offer("bb", 2, TimeUnit.SECONDS));
            System.out.println(queue.offer("cc", 2, TimeUnit.SECONDS));
            System.out.println(queue.offer("dd", 2, TimeUnit.SECONDS));

            System.out.println(queue.poll(2, TimeUnit.SECONDS));
            System.out.println(queue.poll(2, TimeUnit.SECONDS));
            System.out.println(queue.poll(2, TimeUnit.SECONDS));
            System.out.println(queue.poll(2, TimeUnit.SECONDS));

        }
}
