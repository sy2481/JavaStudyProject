package com.sunzhouyu.classloader;

/**
 * @author sunyi
 * @create 2019/1/1
 */
public class Demo extends Object {
    public static void main(String[] args) {
        AA a = new AA();
        System.out.println(AA.length);
    }
    public void print(){
        System.out.println(111);
    }

}

class AA {
    public static int length = 100;

    static {
        System.out.println("静态初始化块A");
        System.out.println(length);
        length = 300;
    }

    public AA() {
        System.out.println("创建对象");
    }
}