package com.answer.classload;

/**
 * Created by chao on 2018/8/28.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 4;

    public SuperClass() {
        System.out.println("父类构造方法出发......");
    }
}
