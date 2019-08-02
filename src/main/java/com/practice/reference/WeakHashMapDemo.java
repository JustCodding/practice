package com.practice.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("=======================");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        Map<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        map.put(key,"WeakHashMap");
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());
    }

    private static void myHashMap() {
        Map<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        map.put(key,"HashMap");
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());
    }
}
