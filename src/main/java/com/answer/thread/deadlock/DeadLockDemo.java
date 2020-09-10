package com.answer.thread.deadlock;

/**
 * @Author answer
 * @Date 2019/7/30 10 52
 */

public class DeadLockDemo {
    private static String a = "A";

    private static String b = "B";

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println("1");
                    }
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    synchronized (a) {
                        System.out.println("2");
                    }
                }
            }
        },"t2");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
