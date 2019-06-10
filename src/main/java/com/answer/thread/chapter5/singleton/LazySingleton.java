package com.answer.thread.chapter5.singleton;

/**
 * 懒加载模式 可以控制实例 instance 什么时候被创建
 * @author answer
 * @description
 * @create 2018/4/2 15:05
 **/
public class LazySingleton {
    private LazySingleton () {
        System.out.println("LazySingleton is creawte");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
            return instance;
        }
        return instance;
    }
}
