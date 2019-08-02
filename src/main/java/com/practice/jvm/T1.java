package com.practice.jvm;

public class T1 {
    class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public void alloc(int i){
        new User("name"+i,i);
    }

    public static void main(String[] args) {
        T1 t = new T1();
        long start = System.currentTimeMillis();
        for (int i = 0; i <10000000 ; i++) {
            t.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("cost time:"+(end-start));

    }

}
