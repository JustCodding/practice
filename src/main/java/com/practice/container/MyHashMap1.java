package com.practice.container;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap1 {
    /*
    这里固定写死一个数组，不再写那些像ArrayList的那些数组扩容的东西
    这个案例只是先让自己熟悉下Map 一个简单的map
    * */
    private MyEntry1[] arr = new MyEntry1[999];
    private int size;
    public void put(Object key,Object value){
        //需要考虑key不能重复
        for (int i = 0; i < size; i++) {
            if(arr[i].key.equals(key)){
               arr[i].value = value;
               return;
            }
        }
        MyEntry1 entry = new MyEntry1(key,value);
        arr[size++] = entry;
    }

    public Object get(Object key){
        for (int i = 0; i < size; i++) {
            if(arr[i].key.equals(key)){
                return  arr[i].value;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        MyHashMap1 map = new MyHashMap1();
        map.put("001","cjp");
        map.put("001","my");
        map.put("002","zxc");
        System.out.println(map.get("001"));
        System.out.println(map.get("002"));

        Map map1 = new HashMap();
    }

}

class MyEntry1{
    public Object key;
    public Object value;

    public MyEntry1(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}

