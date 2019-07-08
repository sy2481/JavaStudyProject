package com.sunzhouyu.design.Singleton;

/**
 * 测试饿汉式单例模式
 * @author 尚学堂高淇 www.sxt.cn
 *
 */
public class SingletonDemo1 {

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	private String aa;
	//类初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，天然的是线程安全的！
	private static final SingletonDemo1 instance = new SingletonDemo1();
	
	private SingletonDemo1(){
	}
	
	//方法没有同步，调用效率高！
	public static synchronized SingletonDemo1  getInstance(){
		return instance;
	}
	
}
