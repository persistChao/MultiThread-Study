package com.answer.thread.chapter3.c3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author answer
 * @description
 * @create 2018/2/27 16:28
 **/
public class TestConcurrentLinkedQueue {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    private static int count = 2; // 线程个数
    //CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
    private static CountDownLatch latch = new CountDownLatch(count);

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(4);
        TestConcurrentLinkedQueue.offer();
        for (int i =0;i<count;i++) {
            es.submit(new Poll());
        }
        latch.await();
        System.out.println("cost time " + (System.currentTimeMillis() - startTime) + "ms");
        es.shutdown();
    }
    /**
     * 生产
     */
    public static void offer() {
        for (int i = 0; i<100000;i++) {
            queue.offer(i);
        }
    }

    public static class Poll implements Runnable {
        public void run() {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            latch.countDown();
        }
    }
}
