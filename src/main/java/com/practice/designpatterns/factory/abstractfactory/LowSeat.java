package com.practice.designpatterns.factory.abstractfactory;

public class LowSeat implements  Seat {
    @Override
    public void support() {
        System.out.println("低端汽车座椅,简单实惠...");
    }
}
