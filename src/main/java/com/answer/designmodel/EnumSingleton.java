package com.answer.designmodel;


import sun.misc.Resource;

/**
 * 使用枚举实现单例模式
 * Created by chao on 2018/9/3.
 */
public class EnumSingleton {

    private EnumSingleton(){}
    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;
        private EnumSingleton singleton;

        private Singleton(){
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return singleton;
        }
    }

    public static void main(String[] args) {
        EnumSingleton obj1 = EnumSingleton.getInstance();
        EnumSingleton obj2 = EnumSingleton.getInstance();
        System.out.println("obj1==obje2:" + (obj1 == obj2));
    }

}
