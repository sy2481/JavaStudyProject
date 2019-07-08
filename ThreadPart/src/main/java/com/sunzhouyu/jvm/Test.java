package com.sunzhouyu.jvm;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();  
        for(GarbageCollectorMXBean b : l) {  
            System.out.println(b.getName());

        }


//		List<String> list=new  ArrayList<>();
//
//		list.add("d");
//		list.add("33");
//		list.add("44");
//		list.add("55");
//		list.add("66");
//
//		List<String> list2 = list.subList(0, 2);
//
//		System.out.println(list.size());//5
//		System.out.println(list2.size());//2

		List<String> list=new  ArrayList<>();
		list.add("d");
		list.add("33");
		list.add("44");
		list.add("55");
		list.add("66");

//		List<String> list2 = list.subList(0, 2);

		List<Object> list2 = new ArrayList<Object>(list.subList(0,2));
		list2.add("77");

		System.out.println(list.size());//6
		System.out.println(list2.size());//3
        try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
