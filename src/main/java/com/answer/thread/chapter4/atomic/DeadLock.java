package com.answer.thread.chapter4.atomic;

import java.util.concurrent.TimeUnit;

/**
 * @author answer
 * @description 哲学家吃饭问题-> 死锁
 * @create 2018/4/2 13:54
 **/
public class DeadLock extends Thread{
    protected Object tool;
    static Object fork1 = new Object();
    static Object fork2 = new Object();

    public DeadLock(Object obj) {
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
            synchronized (fork1) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork2) {
                    System.out.println("哲学家A开始吃饭了");
                }
            }
        }
        if (tool == fork2) {
            synchronized (fork2) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork1) {
                    System.out.println("哲学家B开始吃饭了");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock A = new DeadLock(fork1);
        DeadLock B = new DeadLock(fork2);
        A.start();
        B.start();
        Thread.sleep(1000);
    }
}
