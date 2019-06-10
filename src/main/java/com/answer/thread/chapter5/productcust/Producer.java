package com.answer.thread.chapter5.productcust;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者 并行程序中求 平均数
 * @author answer
 * @description
 * @create 2018/4/2 15:47
 **/
public class Producer implements Runnable{
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("start producer id = " + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());//构造任务数据
                System.out.println(data + " is into queue");
                //提交数据到缓冲区中 如果缓冲区已存在2个则等待消费，消费完成使缓冲区的数据小于2则继续offer想缓冲区放入
                if (!queue.offer(data, 2 , TimeUnit.SECONDS)) {
                    System.err.println("failed to put data:" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
