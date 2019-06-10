package com.answer.thread.chapter3.c2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author answer
 * @description 定时调度线程演示
 * @create 2018/2/24 15:57
 **/
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        //如果前面的任务没有完成,则调度不会启动
//        ses.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                    System.out.println(System.currentTimeMillis()/1000);
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        } , 0 , 2 , TimeUnit.SECONDS);

        System.out.println(-1 << 29);
        ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(System.currentTimeMillis()/1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } , 0 ,2,TimeUnit.SECONDS);
    }
}
