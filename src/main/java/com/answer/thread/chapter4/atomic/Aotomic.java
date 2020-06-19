package com.answer.thread.chapter4.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/6/2 10:36 上午
 **/
public class Aotomic {
    private static final int MAX_THREADS = 3;
    private static final int TASK_COUNT = 3;
    private static final int TARGET_COUNT = 10000000;

    private AtomicLong acount = new AtomicLong(0L);
    private long count = 0;

    static CountDownLatch cdlsync = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdlatomic = new CountDownLatch(TASK_COUNT);

    protected synchronized long inc() {
        return ++count;
    }

    protected synchronized long getCount() {
        return count;
    }

    protected void clearCount() {
        count = 0;
    }

    public class SyncThread implements Runnable {
        protected String name;
        protected long starttime;

        Aotomic out;

        public SyncThread(Aotomic o, long starttime) {
            this.out = o;
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = out.getCount();
            while (v < TARGET_COUNT) {
                v = out.inc();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("SyncThread spend:" + (endTime - starttime) + "ms v=" + v);
            cdlsync.countDown();
        }
    }

    public void testSync() throws Exception {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long startTime = System.currentTimeMillis();
        SyncThread sync = new SyncThread(this, startTime);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(sync);
        }
        cdlsync.await();
        exe.shutdown();
    }

    public class AtomicThread implements Runnable {
        protected String name;
        protected long starttime;

        public AtomicThread(long starttime) {
            this.starttime = starttime;
        }

        @Override
        public void run() {
            long v = acount.get();
            while (v < TARGET_COUNT) {
                v = acount.incrementAndGet();
            }
            System.out.println("AtomicThread spend:" + (System.currentTimeMillis() - starttime) + "ms" + " v=" + v);
            cdlatomic.countDown();
        }

    }

    public void testAtomic() throws Exception{
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long starttime = System.currentTimeMillis();
        AtomicThread atomic = new AtomicThread(starttime);
        for (int i = 0; i <TASK_COUNT ; i++) {
            exe.submit(atomic);
        }
        cdlatomic.await();
        exe.shutdown();
    }

    public static void main(String[] args) throws Exception {
        Aotomic c = new Aotomic();
        c.testAtomic();
        c.testSync();
    }
}