package com.answer.thread.chapter5.productcust;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * @author answer
 * @description
 * @create 2018/4/2 15:57
 **/
public class Consumer implements Runnable{
    private BlockingQueue<PCData> queue ;//缓冲区
    private static final int SLEEPTIME = 1000;
    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id=" + Thread.currentThread().getId());
        Random r = new Random();
        boolean execFlag = true;
        try{
            while (execFlag) {
                PCData data = queue.take();
                if (null != data) {
                    int re = data.getData() * data.getData();//求平方
                    System.out.println("消费结果:" + MessageFormat.format("{0}*{1}={2}",data.getData() , data.getData() , re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
