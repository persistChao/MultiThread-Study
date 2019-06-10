package com.answer.thread.chapter4.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Integer的原子性操作 CAS
 * Created by chao on 2018/3/17.
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                i.incrementAndGet();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int i = 0; i < 10 ; i++) {
            ts[i] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        System.out.println(i);
    }
}
