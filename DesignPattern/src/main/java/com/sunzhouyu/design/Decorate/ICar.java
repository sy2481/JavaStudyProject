package com.sunzhouyu.design.Decorate;

/**
 * @author sunyi
 * @create 2019/1/6
 */
public interface ICar {
    void move();
}

class Car implements ICar {
    @Override
    public void move() {
        System.out.println("陆地上跑");
    }
}

class SuperCar implements ICar {

    protected ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();

    }
}

class Flycar extends SuperCar {

    public Flycar(ICar car) {
        super(car);
    }

    public void fly(){
        System.out.println("车子在飞");
    }

    public void move(){
        super.move();
        fly();
    }
}

class WaterCar extends SuperCar {

    public WaterCar(ICar car) {
        super(car);
    }

    public void swim(){
        System.out.println("车子在游");
    }

    public void move(){
        super.move();
        swim();
    }
}