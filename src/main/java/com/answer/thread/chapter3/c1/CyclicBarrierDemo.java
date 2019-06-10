package com.answer.thread.chapter3.c1;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author answer
 * @description 同步屏障 /循环栅栏 Soldier士兵
 * @create 2018/2/13 14:53
 **/
public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(CyclicBarrier cyclic, String soldierName) {
            this.soldier = soldierName;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                //等待所有（10个）士兵到齐
//                System.out.println(Thread.currentThread().getName() + "集合！");
                cyclic.await();
                doWork();
                //等待所有士兵完成工作
                cyclic.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":任务完成");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int n;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            this.n = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：[士兵: " + n + "个 ，任务完成]");
            } else {
                System.out.println("司令： [士兵：" + n + "个，集合完毕]");
                flag = true;
            }
         }
    }

    public static void main(String[] args) {
        final int n = 10;
        Thread[] allSoldier = new Thread[10];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new BarrierRun(flag, n));
        //设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍！");
        for (int i = 0; i < n; ++i) {
            System.out.println("士兵" + i + "报道");
            allSoldier[i] = new Thread(new Soldier(cyclicBarrier, "士兵" + i));
            //如果中断线程 会抛出异常
//                if (i == 5) {
//                    allSoldier[0].interrupt();
//                }
            allSoldier[i].start();
        }
    }
}

