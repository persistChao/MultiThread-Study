package com.answer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chao on 2018/9/9.
 */
public class DynamicProxyHandler implements InvocationHandler{
    private Object proxyed;

    public DynamicProxyHandler(Object proxyed) {
        this.proxyed = proxyed;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理了工作。");

        return method.invoke(proxyed ,args);
    }

}
