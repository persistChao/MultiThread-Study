package com.answer.thread.chapter3.c2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chao on 2018/8/31.
 */
public class TestFixedThreadPool {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            MyTask task = new MyTask();
//            ExecutorService executorService = Executors.newFixedThreadPool(5);
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i=0;i < 10;i++) {
                executorService.submit(task);
            }
        }
    }
}
