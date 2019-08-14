package com.practice.designpatterns.factory.abstractfactory;

public class LuxuryEngine implements Engine {
    @Override
    public void run() {
        System.out.println("高端引擎,动力大,运行稳定快速...");
    }
}
