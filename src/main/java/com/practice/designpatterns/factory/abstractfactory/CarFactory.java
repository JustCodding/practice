package com.practice.designpatterns.factory.abstractfactory;

public interface CarFactory {
    Engine createEine();
    Seat createSeat();
    Tire createTire();
}
