package com.sunzhouyu.design.Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunyi
 * @create 2019/1/4
 */
public class StarHandle implements InvocationHandler {
    private Star realStar;

    public StarHandle(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object=null;
//        System.out.println("#####");
//        if (method.getName().equals("sing")) {
//            object= method.invoke(realStar, args);
//        } else {
//            System.out.println("proxy " + method.getName());
//        }
        object= method.invoke(realStar, args);
        return object;
    }
}
