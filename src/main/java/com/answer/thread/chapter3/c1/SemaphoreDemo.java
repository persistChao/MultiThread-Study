package com.answer.thread.chapter3.c1;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author answer
 * @description
 * @create 2018/2/12 16:05
 **/
public class SemaphoreDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + Thread.currentThread().getName() + " :done") ;
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0 ; i < 20 ; i++) {
            exec.submit(demo);
        }
    }


    /**
     * 假若一个工厂有5台机器，但是有8个工人，一台机器同时只能被一个工人使用，只有使用完了，
     * 其他工人才能继续使用。那么我们就可以通过Semaphore来实现：
     */
    @Test
    public void testSemaphore() {
        int n = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i  = 0; i < n ; i ++) {
            new Worker(i , semaphore).start();
        }
    }
    public static class Worker extends Thread {
        private  int num;
        private Semaphore semaphore1;
        public Worker(int num , Semaphore semaphore) {
            this.num = num;
            this.semaphore1 = semaphore;
        }
        @Override
        public void run() {
            try {
                semaphore1.acquire();
                System.out.println("工人 " + this.num + " 占用一个机器生产。。。");
//                Thread.sleep(2000);
                System.out.println("工人 " + this.num + " 释放机器");
                semaphore1.release();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
