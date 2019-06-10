package com.answer.thread.chapter3.c1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author answer
 * @description 公平所 即 new ReentrantLock(true) 参数为true时为公平所 一般不使用 性能低
 * @create 2018/2/12 15:13
 **/
public class FairLock implements Runnable{
    public static ReentrantLock fairLock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally{
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1 , "thread_t1");
        Thread t2 = new Thread(r1 , "thread_t2");
        t1.start();
        t2.start();
    }
}
