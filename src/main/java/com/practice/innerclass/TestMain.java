package com.practice.innerclass;

public class TestMain {
    public static void main(String[] args) {
        String id = new OutClass().id;
        OutClass.InnerClass inner = new OutClass().new InnerClass();
    }
}
