package com.answer.thread.actual;

/**
 * Created by chao on 2018/3/12.
 */
public class VolitelDemo {
    private static volatile int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
        Thread.sleep(200);
        System.out.println(count);
    }
    public static class ThreadA extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        }
    }

    public static class ThreadB extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        }
    }


}
