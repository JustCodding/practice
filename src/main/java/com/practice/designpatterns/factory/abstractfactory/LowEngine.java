package com.practice.designpatterns.factory.abstractfactory;

public class LowEngine implements Engine {
    @Override
    public void run() {
        System.out.println("低端引擎,动力弱,价格便宜...");
    }
}
