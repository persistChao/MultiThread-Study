package com.answer.thread.chapter1and2;/**
 * @Author: suchao
 * @Description:
 * @Date Create in 14:40 2017/12/8
 * @Modified by:
 */

/**
 * @author Administrator
 * @description
 * @create 14:40
 **/
public class TestThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("the currentThread is interrupted");
                        break;
                    }
//                    System.out.println(new Date());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interruted When Sleep");
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
        };

        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
