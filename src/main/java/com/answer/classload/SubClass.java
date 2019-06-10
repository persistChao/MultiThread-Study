package com.answer.classload;

/**
 * Created by chao on 2018/8/28.
 */
public class SubClass extends SuperClass{
    static {
        System.out.println("Subclass init");
    }

    public SubClass() {
        System.out.println("子类构造方法出发。。。");
    }
}
