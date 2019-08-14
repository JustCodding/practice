package com.practice.designpatterns.factory.abstractfactory;


public class LowCarFactory implements CarFactory {
    @Override
    public Engine createEine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tire createTire() {
        return new LowTire();
    }
}
