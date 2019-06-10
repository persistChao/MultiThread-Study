package com.answer.thread.chapter5.productcust;

import com.lmax.disruptor.WorkHandler;

/**
 * 使用Disruptor实现消费者
 * @author answer
 * @description
 * @create 2018/4/2 16:43
 **/
public class DisruptorConsumer implements WorkHandler<DisruptorData> {
    //onEvent为框架的回调方法
    public void onEvent(DisruptorData data) throws Exception {
        System.out.println(Thread.currentThread().getId() + " :Event: --" + data.getValue()*data.getValue() + "----");
    }
}
