package com.sunzhouyu.design.Proxy.dynamicProxy;

/**
 * 模拟动态生成的代理的结构
 * @author Administrator
 *
 */
public class ProxyStar implements Star {
	
	StarHandle handler;
	
	public ProxyStar(StarHandle handler) {
		super();
		this.handler = handler;
	}

	public String bookTicket() {
//		handler.invoke(this,当前方法 , args);
		return "";
	}

	public void collectMoney() {
//		handler.invoke(this,当前方法 , args);
	}

	public void confer() {
//		handler.invoke(this,当前方法 , args);
	}

	public void signContract() {
//		handler.invoke(this,当前方法 , args);
	}

	public void sing() {
//		handler.invoke(this,当前方法 , args);
	}

}
