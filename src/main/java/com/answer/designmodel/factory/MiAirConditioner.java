package com.answer.designmodel.factory;

/**
 * Created by chao on 2018/9/3.
 */
public class MiAirConditioner implements AirConditioner {
    @Override
    public void isUse() {
        System.out.println("小米空调使用中。。。");
    }
}
