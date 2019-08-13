package com.practice.designpatterns.factory.factorymethod;

import com.practice.designpatterns.factory.Car;

public class FactoryMethodTest {
    public static void main(String[] args) {
            Car car1 = new AudiFactory().createCar();
            Car car2 = new BydFactory().createCar();
            car1.run();
            car2.run();
    }
}
