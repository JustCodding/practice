package com.practice.designpatterns.factory.factorymethod;

import com.practice.designpatterns.factory.Byd;
import com.practice.designpatterns.factory.Car;

public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
