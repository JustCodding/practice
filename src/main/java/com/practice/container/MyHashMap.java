package com.practice.container;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyHashMap {

    private LinkedList[] arr = new LinkedList[999];
    public void put(Object key,Object value){
        int hash = key.hashCode();
        hash = hash<0?-hash:hash;//hash可能是负数值
        int index = hash%arr.length;
        if(arr[index]==null){//这个位置还没放数据
            LinkedList list = new LinkedList();
            MyEntry entry = new MyEntry(key,value);
            list.add(entry);
            arr[index] = list;
        }else {//映射到某一位置，已经有了链表
            LinkedList list = arr[index];
            //需要做key是否已经存在
            for (int i = 0; i < list.size(); i++) {
                MyEntry entry = (MyEntry) list.get(i);
                if(entry.key.equals(key)){//如果已经存在这个key,进行value覆盖
                    entry.value = value;
                    return;
                }
            }

            //不存在这个key,则直接将这个元素添加到链表中
            list.add(new MyEntry(key, value));
        }
    }

    public Object get(Object key){
        int hash = key.hashCode();
        hash = hash<0?-hash:hash;//hash可能是负数值
        int index = hash%arr.length;
        if(arr[index]!=null){
            LinkedList list = arr[index];
            for (int i = 0; i < list.size(); i++) {
                MyEntry entry = (MyEntry) list.get(i);
                if(entry.key.equals(key)){//如果找到这个key  直接返回value
                    return entry.value;
                }
            }
        }
        return null;

    }
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("001","cjp");
        map.put("001","cjp2");
        map.put("002","cyy");
        System.out.println(map.get("001"));
        System.out.println(map.get("002"));
        System.out.println(map.get("003"));

    }

}

class MyEntry{
    public Object key;
    public Object value;

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}

