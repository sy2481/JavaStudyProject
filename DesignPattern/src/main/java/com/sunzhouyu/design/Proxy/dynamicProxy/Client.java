package com.sunzhouyu.design.Proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author sunyi
 * @create 2019/1/4
 */
public class Client {
    public static void main(String[] args) {
        Star realStar2 = new RealStar2();

        StarHandle starHandle = new StarHandle(realStar2);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, starHandle);
        proxy.confer();
        System.out.println(proxy.bookTicket());
        proxy.sing();
        proxy.collectMoney();
    }
}
