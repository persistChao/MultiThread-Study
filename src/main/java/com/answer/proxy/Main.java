package com.answer.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by chao on 2018/9/9.
 */
public class Main {
    public static void main(String[] args) {
        RealObject real = new RealObject();
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[] {Interface.class},
                new DynamicProxyHandler(real));

        proxy.doSomething();
        proxy.sometingElse("suchao27");
    }
}
