package com.practice.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(obj,referenceQueue);
        System.out.println(obj);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("================");
        obj = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(obj);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }
}
