package com.answer.designmodel.factory;

/**
 * Created by chao on 2018/9/3.
 */
public class MiTV implements TV{
    @Override
    public void play() {
        System.out.println("小米电视播放中...");
    }
}
