package com.answer.thread.actual;

import java.util.concurrent.TimeUnit;

/**
 * Created by chao on 2018/3/12.
 */
public class Test {
    private static volatile    boolean stopThread;
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopThread) {
                    i++;
                }
            }
        });
        th.start();
        TimeUnit.SECONDS.sleep(2);
        stopThread = true;
    }
}
