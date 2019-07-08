package com.sunzhouyu.memory;

/**
 * @Author sunyi
 * @Date: 2019/1/22
 */
public class Test {

    public static void main(String[] args) {

        Student stu = new Student();

        stu.name = "xiaoming";

        stu.age = 10;

        stu.study();

        Computer c = new Computer();
        c.brand = "Hasse";

        System.out.println(c.brand);

        stu.computer = c;
        System.out.println(stu.computer.brand);

        System.out.println("----------------------------------------");

        c.brand = "Dell";

        System.out.println(c.brand);
        System.out.println(stu.computer.brand);

        System.out.println(stu.computer.brand == c.brand);
        String str = "Dell";
        System.out.println(c.brand == str);

    }

}

class Computer {
    int price;

    String brand;
}

class Student {

    int score;

    int age;

    String name;

    Computer computer;

    public void study() {

        System.out.println("studying...");
    }
}
