package com.answer.thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/4 11:58 上午
 */
public class TestVolatile {

    private static int a = 1;

    private int b ;

    public TestVolatile(int b ) {
        this.b = b;
    }


    public void setValue() {
        a = b;
        System.out.println("a = " + a);
    }


    public static void main(String[] args) {
        TestVolatile t = new TestVolatile(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(a);
                t.setValue();
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(a);
                t.setValue();
            }
        },"t2").start();


        System.out.println(a);
    }

}
