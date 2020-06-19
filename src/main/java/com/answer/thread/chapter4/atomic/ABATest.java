package com.answer.thread.chapter4.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/6/19 6:42 下午
 **/
public class ABATest {
    private AtomicInteger a = new AtomicInteger(1);
    private AtomicReference<Integer> b = new AtomicReference<>(1);

    @Test
    public void testAtomicIntegerAndAtomicReference() {
        for (int i = 0; i <1000 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a.incrementAndGet();
                    Integer x = b.get();
                    b.compareAndSet(x, x + 1);
                }
            }).start();

        }
        System.out.println("a="+a + ",b="+b);
    }

    @Test
    public void testABA() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer x = a.get();
                System.out.println(Thread.currentThread().getName() +" a 当前值==" + x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.compareAndSet(x ,x+1);
                System.out.println(Thread.currentThread().getName() +" a 当前值===" + a.get());
                a.compareAndSet(a.get() ,1);
                System.out.println(Thread.currentThread().getName() + " a 当前值====" + a.get());
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer x = a.get();
                System.out.println(Thread.currentThread().getName() + " a 当前值==" + x);

            }
        }).start();
    }
}
