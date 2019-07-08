package com.sunzhouyu.design.Factory.simplefactory;

public class CarFactory {

    public static Car createCar(String type) {
        if ("奥迪".equals(type)) {
            return new Audi();
        } else if ("比亚迪".equals(type)) {
            return new Byd();
        } else {
            return null;
        }
    }

//    public Car createCar(String type) {
//        if ("奥迪".equals(type)) {
//            return new Audi();
//        } else if ("比亚迪".equals(type)) {
//            return new Byd();
//        } else {
//            return null;
//        }
//    }

}
