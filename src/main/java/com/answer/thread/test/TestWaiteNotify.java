package com.answer.thread.test;

/**
 * wait notify 必须跟随synchronized一起使用
 *
 * @author answer
 * @version 1.0.0
 * @date 2020/9/3 11:20 上午
 */
public class TestWaiteNotify {
    private static final Object obj = new Object();

    public static class ThreadT1 implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("Thread1 is start....");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" Thread1 is go to ....");

            }
        }
    }
    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(" T2 is start....");
                obj.notifyAll();
                System.out.println("T2 is go to ...");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new T2();
        Thread t1 = new Thread(new ThreadT1());
        t1.start();
        Thread.sleep(10);
        t2.start();
    }
}
