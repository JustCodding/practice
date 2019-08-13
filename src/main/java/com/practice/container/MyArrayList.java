package com.practice.container;

import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
* 要支持增强for,必须实现Iterable接口，我们重写该接口的iterator方法
* 此方法是返回迭代器*/
public class MyArrayList implements Iterable{
    private Object[] elemetData;
    private int size;
    public MyArrayList(int initialCapacity){
        if(initialCapacity<0){
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
        this.elemetData = new Object[initialCapacity];
    }
    public MyArrayList(){
        this(10);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
    //往容器中添加元素
    public void add(Object element){
        //添加元素之前要判断容器大小是否够用，不够用要进行扩容和数据拷贝
        ensureCapacity();
        this.elemetData[size++] = element;
    }

    //扩容和数据拷贝
    private void ensureCapacity() {
        if(this.size+1>elemetData.length){
            Object[] newArr = new Object[elemetData.length*2+1];
            System.arraycopy(elemetData,0,newArr,0,elemetData.length);
            /*for (int i = 0; i <elemetData.length ; i++) {
                newArr[i] = elemetData[i];
            }*/
            elemetData = newArr;
        }
    }

    //根据索引查找元素
    public Object get(int index){
        /*if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }*/
        rangeCheck(index);
        return elemetData[index];
    }

    private void rangeCheck(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
    //按索引删除
    public Object remove(int index){
        rangeCheck(index);
        Object oldValue = elemetData[index];
        //被删除的元素后面有多少个元素
        int numMoved = size-1-index;
        if(numMoved>0){
            System.arraycopy(elemetData,index+1,elemetData,index,numMoved);
        }
        elemetData[--size] = null;
        return  oldValue;
    }
    //按元素删除
    public boolean remove(Object object){
        for (int i = 0; i < size; i++) {
            if(elemetData[i].equals(object)){//这里底层用equals进行比较，且只会删除一个
                remove(i);
                return true;
            }
        }
        return false;
    }

    //修改某个位置元素
    public Object set(int index,Object obj){
        rangeCheck(index);
        Object oldValue = elemetData[index];
        elemetData[index] = obj;
        return  oldValue;
    }

    //在某个位置插入元素
    public boolean add(int index,Object object){
        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(elemetData,index,elemetData,index+1,size-index);
        elemetData[index] = object;
        return true;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int cursor = -1;
            @Override
            public boolean hasNext() {
                return cursor+1<size;
            }

            @Override
            public Object next() {
                return elemetData[++cursor];
            }

            @Override
            public void remove() {
                //这里未实现
            }
        };
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(3);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        for (int i = 0; i <list.size ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=================");
        list.remove(2);
        for (int i = 0; i <list.size ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=================");
        list.set(2,"000");
        for (int i = 0; i <list.size ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=================");
        list.add("abc");
        list.add("efg");
        list.remove("000");
        for (int i = 0; i <list.size ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=================");
        list.add(1,"kkk");
        for (int i = 0; i <list.size ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=================");
        list.remove(null);
        for (int i = 0; i <list.size ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=======增强for遍历==========");
        for (Object obj:list) {
            System.out.println(obj);
        }

        System.out.println("=======迭代器遍历==========");
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

}
