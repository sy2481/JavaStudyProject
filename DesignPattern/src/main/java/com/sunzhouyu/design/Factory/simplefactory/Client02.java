package com.sunzhouyu.design.Factory.simplefactory;

/**
 * 简单工厂情况下
 *
 * @author 尚学堂高淇 www.sxt.cn
 */
public class Client02 {   //调用者

    public static void main(String[] args) {
//        CarFactory factory = new CarFactory();
//        Car c1 = factory.createCar("奥迪");
//        Car c3 = factory.createCar("奥迪");
//        Car c2 = factory.createCar("比亚迪");

                Car c1 = CarFactory.createCar("奥迪");
        Car c3 = CarFactory.createCar("奥迪");
        Car c2 = CarFactory.createCar("比亚迪");

        System.out.println(c1 == c3);
        c1.run();
        c2.run();

    }
}
