package com.practice.designpatterns.factory.simplefactory;

import com.practice.designpatterns.factory.Audi;
import com.practice.designpatterns.factory.Byd;
import com.practice.designpatterns.factory.Car;

public class CarFactory {
    public static Car createCar(String carName){
        Car car = null;
        if("奥迪".equals(carName)){
            car = new Audi();
        }else if("比亚迪".equals(carName)){
            car = new Byd();
        }
        return car;
    }

    /*
    简单工厂的第二种实现方式，为每一种具体的car提供一个创建方法
     */
    public static Car createAudi(){
        return new Audi();
    }
    public static Car createByd(){
        return new Byd();
    }
}
