package com.sunzhouyu.design.Decorate;

/**
 * @author sunyi
 * @create 2019/1/6
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        System.out.println("-----------");
        Flycar flycar = new Flycar(car);
        flycar.move();
        System.out.println("-----------");
        WaterCar waterCar = new WaterCar(flycar);
        waterCar.move();
        System.out.println("-----------");
        WaterCar waterCar1 = new WaterCar(new Flycar(new Car()));
        waterCar1.move();
    }
}
