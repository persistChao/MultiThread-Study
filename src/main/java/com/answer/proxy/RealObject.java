package com.answer.proxy;

/**
 * Created by chao on 2018/9/9.
 */
public class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println("doSomething .");
    }

    @Override
    public void sometingElse(String val) {
        System.out.println("do else something");
    }
}
