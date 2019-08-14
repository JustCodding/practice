package com.practice.designpatterns.factory.abstractfactory;

public class LuxurySeat implements Seat {
    @Override
    public void support() {
        System.out.println("高端汽车座椅,真皮的,柔软舒服...");
    }
}
