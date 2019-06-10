package com.answer.thread.chapter3.c2;

import java.util.concurrent.*;

/**
 * @author answer
 * @description
 * @create 2018/2/26 10:01
 **/
public class ThreadFactoryDemo {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0l, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        System.out.println("create " + t);
                        return t;
                    }
                });
        for (int i = 0; i < 5; i++) {
            es.submit(task);
        }
        Thread.sleep(2000);
    }

    public static class MyTask implements Runnable {

        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
