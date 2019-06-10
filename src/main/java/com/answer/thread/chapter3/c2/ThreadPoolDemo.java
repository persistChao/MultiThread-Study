package com.answer.thread.chapter3.c2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author answer
 * @description 线程池使用演示
 * @create 2018/2/24 14:40
 **/
public class ThreadPoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " : Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
//        ExecutorService es = Executors.newFixedThreadPool(5);
        ExecutorService e = Executors.newCachedThreadPool();
        for (int  i = 0; i <10 ; i++) {
            e.submit(task);
        }
    }
}
