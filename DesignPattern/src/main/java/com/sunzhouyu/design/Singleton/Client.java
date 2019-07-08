package com.sunzhouyu.design.Singleton;

public class Client {
	
	public static void main(String[] args) {
		SingletonDemo1 s1 = SingletonDemo1.getInstance();
//		System.out.println(s1.getAa());
		s1.setAa("1123123");
		SingletonDemo1 s2 = SingletonDemo1.getInstance();
		System.out.println(s2.getAa());
		System.out.println(s1);
		System.out.println(s2);
		

		
		
	}
}
