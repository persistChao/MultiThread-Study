package com.answer.thread.chapter5.productcust;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * 给予disruptor实现的生产者
 * @author answer
 * @description
 * @create 2018/4/2 16:51
 **/
public class DisruptorProducer {
    private final RingBuffer<DisruptorData> ringBuffer;

    public DisruptorProducer(RingBuffer<DisruptorData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * 将传入的ByteBuffer中的数据提取出来 并装在到环形缓冲区
     * @param bb
     */
    public void pushData(ByteBuffer bb) {
        //获取下一个序列
        long sequece = ringBuffer.next();
        try {
            //从队列中获取数据
            DisruptorData data = ringBuffer.get(sequece);
            //填写数据
            data.setValue(bb.getLong(0));
        }finally {
            ringBuffer.publish(sequece);
        }
    }
}
