package com.answer.thread.chapter1and2;

/**
 * @author answer
 * @description
 * @create 2018/3/20 9:49
 **/
public class ThreadYield {

    public static class ThreadDemo implements Runnable{

        @Override
        public void run() {
//            for (int i = 0; i < 5; i++) {
//                if (i==3) {
                    System.out.println("当前线程是" + Thread.currentThread().getName());
                    Thread.currentThread().yield();
//                }
                System.out.println("执行的是" + Thread.currentThread().getName());
//            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        Thread t1 = new Thread(demo , "花花");
        Thread t2 = new Thread(demo , "草草");
        t1.start();
        t2.start();
    }
}
