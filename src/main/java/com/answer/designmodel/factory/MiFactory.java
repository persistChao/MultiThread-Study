package com.answer.designmodel.factory;

/**
 * Created by chao on 2018/9/3.
 */
public class MiFactory implements EFactory{
    @Override
    public TV produceTV() {
        return new MiTV();
    }

    @Override
    public AirConditioner produceAirConditioner() {
        return new MiAirConditioner();
    }
}
