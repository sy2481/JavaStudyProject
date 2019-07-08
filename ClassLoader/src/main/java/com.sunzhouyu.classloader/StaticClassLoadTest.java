package com.sunzhouyu.classloader;

/**
 * @author sunyi
 * @create 2019/1/2
 */

class StaticVar {

    static {
        System.out.println("StaticClass loading...");
    }

    public static String VALUE = "static value loading";

    public static final String FIANL_VALUE = "fianl value loading";
}


public class StaticClassLoadTest {
    public static void main(String[] args) {
        System.out.println("StaticClassLoadTest...");
        printStaticVar();
    }

    private static void printStaticVar() {
        System.out.println(StaticVar.FIANL_VALUE);
        System.out.println(StaticVar.VALUE);

    }

}

