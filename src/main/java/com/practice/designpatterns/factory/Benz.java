package com.practice.designpatterns.factory;

public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("奔驰车在跑...");
    }
}
