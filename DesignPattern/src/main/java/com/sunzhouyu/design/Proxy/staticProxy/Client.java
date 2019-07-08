package com.sunzhouyu.design.Proxy.staticProxy;

/**
 * @author sunyi
 * @create 2019/1/4
 */
public class Client {
    public static void main(String[] args) {
        Star real=new RealStar();

        Star proxy=new ProxyStar(real);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();

    }

}
