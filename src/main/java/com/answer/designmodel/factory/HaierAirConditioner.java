package com.answer.designmodel.factory;

/**
 * Created by chao on 2018/9/3.
 */
public class HaierAirConditioner implements AirConditioner {
    @Override
    public void isUse() {
        System.out.println("海尔空调使用中。。。");
    }
}
