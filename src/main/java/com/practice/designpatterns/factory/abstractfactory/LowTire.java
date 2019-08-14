package com.practice.designpatterns.factory.abstractfactory;

public class LowTire implements Tire {
    @Override
    public void rotate() {
        System.out.println("低端轮胎,噪音大耐磨差抓地差价格便宜...");
    }
}
