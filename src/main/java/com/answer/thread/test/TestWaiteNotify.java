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
                System.out.println(Thread.currentThread().getName() +" is start....");
                try {
                    System.out.println(Thread.currentThread().getName() + " is wait and other Thread can run....");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is go to execute...");

            }
        }
    }
    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() +"  is start....");
                System.out.println(Thread.currentThread().getName() + " 唤醒其他线程继续执行...");
                obj.notifyAll();
                System.out.println(Thread.currentThread().getName() +  " is go to execute ...");
            }
        }
    }

    /**
     * t1 is start...
     * t1 is wait and other thread can run ...
     * t2 is start...
     * t2 唤醒其他线程继续执行
     * t1 is go to execute
     * t2 is go to execute
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new T2();
        Thread t1 = new Thread(new ThreadT1(),"t1");
        t1.start();
        Thread.sleep(10);
        t2.start();
    }

}
