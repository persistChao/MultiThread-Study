package com.answer.thread.chapter3.c3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by chao on 2018/9/2.
 */
public class ArrayBlockingQueueTest {
    private ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

    public static void main(String[] args) {
        final ArrayBlockingQueueTest test = new ArrayBlockingQueueTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void producer() throws InterruptedException {
        int i =0;
        while (true) {
            System.out.println("arrayBlockingQueue.size==" + arrayBlockingQueue.size());
            Thread.sleep(100);
            arrayBlockingQueue.put(i++);
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
//            System.out.println(arrayBlockingQueue.poll(10000, TimeUnit.MILLISECONDS));
//            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.poll());
        }
    }
}
