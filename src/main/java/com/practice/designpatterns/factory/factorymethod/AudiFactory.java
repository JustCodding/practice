package com.practice.designpatterns.factory.factorymethod;

import com.practice.designpatterns.factory.Audi;
import com.practice.designpatterns.factory.Car;

public class AudiFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Audi();
    }
}
