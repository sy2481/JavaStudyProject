package com.sunzhouyu.design.Decorate;

/**
 * @author sunyi
 * @create 2018/12/11
 */
public class Decorate {
    public static void main(String[] args) {
        Coffee coffer = new Coffee();
        Suger suger = new Suger(coffer);
        System.out.println(suger.info() + "-->" + suger.cost());
        Milk milk = new Milk(suger);
        System.out.println(milk.info() + "-->" + milk.cost());
        Milk milk1 = new Milk(milk);
        System.out.println(milk1.info() + "-->" + milk1.cost());
    }

}

interface Drink {
    double cost();

    String info();
}

class Coffee implements Drink {

    private String name = "原味咖啡";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

abstract class DecorateClass implements Drink {

    private Drink drink;

    public DecorateClass(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

class Milk extends DecorateClass {
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 4;
    }

    @Override
    public String info() {
        return super.info() + "加入牛奶";
    }
}

class Suger extends DecorateClass {
    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 2;
    }

    @Override
    public String info() {
        return super.info() + "加入糖";
    }
}
