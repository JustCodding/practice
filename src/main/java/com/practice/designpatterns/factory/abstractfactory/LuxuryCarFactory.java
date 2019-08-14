package com.practice.designpatterns.factory.abstractfactory;

public class LuxuryCarFactory implements CarFactory {
    @Override
    public Engine createEine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tire createTire() {
        return new LuxuryTire();
    }
}
