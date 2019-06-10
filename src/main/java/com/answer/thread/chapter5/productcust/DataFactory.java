package com.answer.thread.chapter5.productcust;

import com.lmax.disruptor.EventFactory;

/**
 * @author answer
 * @description
 * @create 2018/4/2 16:53
 **/
public class DataFactory implements EventFactory<DisruptorData> {
    public DisruptorData newInstance() {
        return new DisruptorData();
    }
}
