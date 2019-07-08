package com.sunzhouyu.classloader;

/**
 * @author sunyi
 * @create 2019/1/1
 */
public class Demo1 {
    public static void main(String[] args) {
        //new Parent();
        System.out.println("-------------------");
        new SubClass();
        System.out.println("-------------------");
        new SubClass();
    }
}

class Parent {
    public static String p_StaticField = "父类--静态变量";

    public String p_Field = "父类--变量";

    //父类的静态初始化块
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
    }

    //父类的非静态初始化快
    {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }
    //父类的构造函数

    public Parent() {
        System.out.println("父类--构造器");
    }
}

class SubClass extends Parent {
    public static String s_StaticField = "子类--静态变量";

    public String s_Field = "子类--变量";

    // 子类的静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }
    //子类的非静态初始化快

    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }
    //子类的构造函数

    public SubClass() {
        System.out.println("子类--构造器");
    }

}