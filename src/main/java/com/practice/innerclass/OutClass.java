package com.practice.innerclass;

public class OutClass {
    private String name;
     protected String id;
    protected class InnerClass{ }
    public static void main(String[] args) {
        //OutClass的name属性虽然是private,但是这里还是在类中访问这个私有属性
        String name = new OutClass().name;
        InnerClass inner = new OutClass().new InnerClass();
    }
}
