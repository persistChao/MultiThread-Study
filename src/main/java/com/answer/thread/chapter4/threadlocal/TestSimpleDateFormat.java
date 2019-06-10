package com.answer.thread.chapter4.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SimpleDateFormat 不是线程安全的 ，所以在线程中共享这个对象会出错
 * 解决方案1 可以使用锁 在parse前后 相当于对 sdf对象枷锁
 * 解决方案2 使用synchronized 方法 对sdf同步
 * Created by chao on 2018/2/28.
 */
public class TestSimpleDateFormat {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Lock lock = new ReentrantLock();

    public static class PareseDate implements Runnable {
        int i = 0;

        public PareseDate(int i) {
            this.i = i;
        }

        public void run() {
            try {
                Date t = sdf.parse("2018-02-28 21:20:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        /**
         * 解决方案1 使用重入锁
         */
//        public void run() {
//            try {
//                lock.lock();
//                Date t = sdf.parse("2018-02-28 21:20:" + i % 60);
//                System.out.println(i + ":" + t);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }

        /**
         * 解决方案2 使用synchronized 同步快
         */
//        public void run() {
//            try {
//                synchronized (sdf) {
//                    Date t = sdf.parse("2018-02-28 21:20:" + i % 60);
//                    System.out.println(i + ":" + t);
//                }
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i = 10; i < 1000; i++) {
            es.execute(new PareseDate(i));
        }
    }
}
