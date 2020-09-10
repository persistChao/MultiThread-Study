package com.answer.thread.test;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/4 10:35 上午
 */
public class TwoThreadAlternatePrint {

    public static class Printer implements Runnable {
        private final Object object = new Object();
        int i = 1;
        @Override
        public void run() {
            while (i <= 100) {
                synchronized (object) {
                    object.notifyAll();
                    if (i % 2 == 1) {
                        System.out.print("A");
                    } else {
                        System.out.print("B ");
                    }
                    try {
                        Thread.sleep(100);
                        i++;
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread t1 = new Thread(printer);
        Thread t2 = new Thread(printer);
        t1.setName("线程1");
        t1.start();
        Thread.sleep(100);
        t2.setName("线程2");
        t2.start();
    }
}
