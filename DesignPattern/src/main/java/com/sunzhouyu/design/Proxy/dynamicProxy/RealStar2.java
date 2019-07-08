package com.sunzhouyu.design.Proxy.dynamicProxy;

public class RealStar2 implements Star {

	@Override
	public String  bookTicket() {
		System.out.println("RealStar2.bookTicket()");
		return "12312";
	}

	@Override
	public void collectMoney() {
		System.out.println("RealStar2.collectMoney()");
	}

	@Override
	public void confer() {
		System.out.println("RealStar2.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("RealStar2.signContract()");
	}

	@Override
	public void sing() {
		System.out.println("RealStar2(周杰伦本人).sing()");
	}
	
	
	
}
