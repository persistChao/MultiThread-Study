package com.answer.thread.chapter1and2;/**
 * @Author: suchao
 * @Description:
 * @Date Create in 15:46 2017/12/8
 * @Modified by:
 */

/**
 * @author Administrator
 * @description
 * @create 15:46
 **/
public class TestObjMonitor {


    private final static Object obj = new Object();

    public static  class T1 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ":T1 start! ");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end! ");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + " : T2 start! ");
                obj.notify();
                System.out.println(System.currentTimeMillis()  + " : T2 end! ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
