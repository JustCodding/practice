package com.practice.designpatterns.factory.abstractfactory;

public class LuxuryTire implements Tire {
    @Override
    public void rotate() {
        System.out.println("高端轮胎,静音耐磨抓地强...");
    }
}
