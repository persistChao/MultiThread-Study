package com.answer.thread.chapter3.c1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author answer
 * @description
 * @create 2018/2/12 14:27
 **/
public class TimeLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5 , TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName() + " 进入");
                Thread.sleep(5000);
            }else {
                System.out.println(Thread.currentThread().getName() + " -- get lock failed");
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock TL = new TimeLock();
        Thread t1 = new Thread(TL ,"t1");
        Thread t2 = new Thread(TL , "t2");
        t1.start();
        t2.start();
    }
}
