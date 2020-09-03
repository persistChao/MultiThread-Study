package com.answer.thread.chapter1and2;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/6/22 6:46 下午
 **/
public class VolatileTest3 {
    private  int a = 0;

    private void increase() {
        a = 1;
    }

    private void add3() {
        a = 3;
    }

    public static void main(String[] args) throws InterruptedException {
         VolatileTest3 t3 = new VolatileTest3();
//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j = 0; j < 1000; j++) {
//                        t3.increase();
//                    }
//                }
//            }).start();
//            while (Thread.activeCount() > 1) {
//                Thread.yield();
//            }
//        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t3.increase();
                System.out.println("t1 a=" + t3.a);
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t3.add3();
                System.out.println("t2 a=" + t3.a);
            }
        },"t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("a=" + t3.a);
    }



}

