package com.answer.designmodel.factory;

/**
 * Created by chao on 2018/9/3.
 */
public class HaierFactory implements EFactory{
    @Override
    public TV produceTV() {
        return null;
    }

    @Override
    public AirConditioner produceAirConditioner() {
        return new HaierAirConditioner();
    }
}
