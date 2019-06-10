package com.answer.thread.chapter4.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决死锁问题 哲学家吃饭问题
 *
 * @author answer
 * @description
 * @create 2018/4/2 14:16
 **/
public class SolveDeadLock extends Thread {
    protected Object tool;
    static Object fork1 = new Object();
    static Object fork2 = new Object();
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

    public SolveDeadLock(Object obj) {
        this.tool = obj;
        if (tool == fork1) {
            this.setName("哲学家A");
        }
        if (tool == fork2 ) {
            this.setName("哲学家B");
        }
    }

    @Override
    public void run() {
        if (tool == fork1) {
            try {
                lock1.lockInterruptibly();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("哲学家A开始吃饭了");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (tool == fork2) {
            try {
                lock2.lockInterruptibly();
                System.out.println("哲学家B开始吃饭了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock1.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SolveDeadLock A = new SolveDeadLock(fork1);
        SolveDeadLock B = new SolveDeadLock(fork2);
        A.start();
        B.start();
        Thread.sleep(1000);
    }
}
