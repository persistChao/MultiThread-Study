package com.answer.thread.chapter5.singleton;

/**
 * @author answer
 * @description
 * @create 2018/4/2 15:01
 **/
public class Singleton1 {
    private Singleton1() {
        System.out.println("Singleton is create");
    }
    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}
