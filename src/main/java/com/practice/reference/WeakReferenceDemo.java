package com.practice.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        WeakReference<Object> obj2 = new WeakReference<Object>(obj1);

        System.out.println(obj1);
        System.out.println(obj2.get());

        obj1 = null;
        System.gc();

        System.out.println(obj1);
        System.out.println(obj2.get());
    }
}
