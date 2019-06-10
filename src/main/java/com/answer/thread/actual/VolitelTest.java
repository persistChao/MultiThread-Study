package com.answer.thread.actual;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试可见性问题
 * Created by chao on 2018/3/12.
 */
public class VolitelTest implements Runnable{

    private static boolean ready;
    private static int number;

    private static int i = 0;

    @Override
    public void run() {
        i++;
        System.out.println("i = " + i);
    }

    public static class ReaderThread implements Runnable {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ReaderThread());
        t.start();
        number = 42;
        ready = false;
    }


    @Test
    public void testAdd() throws InterruptedException {

        Thread a = new Thread() {
            public void run() {
                for (int j = 0; j<10000;j++) {
                    i++;
                }
            }
        };
        a.start();
        Thread b = new Thread() {
            public void run() {
                for (int a = 0 ; a<10000 ;a++) {
                    i--;
                }
            }
        };
        b.start();
        a.join();
        b.join();
        System.out.println("i = " + i );
    }

    @Test
    public void testAdd2() {

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int a = 0 ; a<10000 ;a++) {
            VolitelTest v = new VolitelTest();
            service.execute(v);
        }
        while (true) {
            System.out.println();
        }
    }
}
