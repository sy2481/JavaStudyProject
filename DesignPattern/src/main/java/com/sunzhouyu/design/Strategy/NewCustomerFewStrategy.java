package com.sunzhouyu.design.Strategy;

public class NewCustomerFewStrategy implements Strategy {

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("不打折，原价");
		return standardPrice;
	}

}
