package com.answer.thread.chapter4.threadlocal;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 多线程下生成随机数
 * 说明在多线程下使用ThreadLocal 能带来效率的优化 对性能的提升
 * Created by chao on 2018/3/17.
 */
public class ThreadLocalRandom {
    public static final int GEN_COUNT = 10000000;
    public static final int THREAD_COUNT = 4;
    public static ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);
    public static Random rnd = new Random(123);

    public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>(){
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };
    public static class RndTask implements Callable<Long> {
        private int mode = 0;
        public RndTask(int mode ) {
            this.mode = mode;
        }
        public Random getRandom() {
            if (mode == 0) {
                return rnd;
            }else if (mode == 1) {
                return tRnd.get();
            }else {
                return null;
            }
        }

        @Override
        public Long call() throws Exception {
            long b = System.currentTimeMillis();
            for (long i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend " + (e -b) + " ms");
            return e -b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] futs = new Future[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = es.submit(new RndTask(0));
        }
        long totaltime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totaltime += futs[i].get();
        }
        System.out.println("多线程访问同一个Rnadom实例：" + totaltime + "ms");
        //ThreadLocal的情况
        for (int i = 0; i < THREAD_COUNT; i++) {
            futs[i] = es.submit(new RndTask(1));
        }
        totaltime = 0;
        for ( int i = 0; i < THREAD_COUNT; i++) {
            totaltime += futs[i].get();
        }
        System.out.println("使用ThreadLocal 包装Random实例：" + totaltime + "ms");
        es.shutdown();
    }
}
