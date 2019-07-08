package com.sunzhouyu.server.servlet;

/**
 * @author sunyi
 * @create 2018/12/26
 */
public interface Servlet {
    void service();
    void service(Request request,Response response);
}