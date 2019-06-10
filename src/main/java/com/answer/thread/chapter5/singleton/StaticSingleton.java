package com.answer.thread.chapter5.singleton;

/**
 * 使用了内部类和类的初始化方式
 * 内部类SingletonHolder 被申明为private 使得不可能在外部访问并初始化，
 * 而只可能在getInstance内部对SingletonHolder类进行初始化
 * 利用率虚拟机的类初始化机制创建单例
 * @author answer
 * @description
 * @create 2018/4/2 15:08
 **/
public class StaticSingleton {
    private StaticSingleton() {
        System.out.println("StaticSingleton is create");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
