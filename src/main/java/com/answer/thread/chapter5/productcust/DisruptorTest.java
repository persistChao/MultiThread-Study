package com.answer.thread.chapter5.productcust;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author answer
 * @description
 * @create 2018/4/2 17:03
 **/
public class DisruptorTest {

    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        DataFactory factory = new DataFactory();
        int bufferSize  =1024;
        Disruptor<DisruptorData> disruptor = new Disruptor<DisruptorData>(factory ,bufferSize ,
                executor , ProducerType.MULTI , new BlockingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(new DisruptorConsumer() , new DisruptorConsumer() , new DisruptorConsumer() , new DisruptorConsumer());
        disruptor.start();

        RingBuffer<DisruptorData> ringBuffer = disruptor.getRingBuffer();
        DisruptorProducer producer = new DisruptorProducer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0 ; true ; l++) {
            bb.putLong(0,l);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.println("add data " + l);
        }
    }

}
