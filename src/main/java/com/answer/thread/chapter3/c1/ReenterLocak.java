package com.answer.thread.chapter3.c1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author answer
 * @description 重入锁
 * @create 2018/2/12 11:08
 **/
public class ReenterLocak implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000 ; j++) {
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLocak TL = new ReenterLocak();
        Thread t1 = new Thread(TL);
        Thread t2 = new Thread(TL);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
