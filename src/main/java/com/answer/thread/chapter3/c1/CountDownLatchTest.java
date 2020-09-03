package com.answer.thread.chapter3.c1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/8/13 3:15 下午
 */
public class CountDownLatchTest implements Runnable {
    private static final CountDownLatchTest task = new CountDownLatchTest();
    private static final CountDownLatch count = new CountDownLatch(5);


    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(Thread.currentThread().getName() + " task is starting count = " + count.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.countDown();
        System.out.println(Thread.currentThread().getName() + " is done====== count= " + count.getCount());
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            es.submit(task);
        }
        count.await();

        System.out.println(" count is over>>>>");

        es.shutdown();
    }
}
