package com.sunzhouyu.design.Proxy.dynamicProxy;

public class RealStar implements Star {

    @Override
    public String bookTicket() {
        System.out.println("RealStar.bookTicket()");
        return "2222";
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }

    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");
    }

    @Override
    public void sing() {
        System.out.println("RealStar(周杰伦本人).sing()");
    }

}
