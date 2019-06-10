package com.answer.thread.chapter4.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 由于SimpleDateFormat 是非线程安全的
 * 使用ThreadLocal 解决问题
 * <p>
 * Created by chao on 2018/2/28.
 */
public class ThreadLocalSimpleDateFormat {
    static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();

    public static class ParseDate implements Runnable {
        int i = 0;
        public ParseDate(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            try {
                //如果当前线程不持有SimpleDateFormat的对象锁，则新建一个并把它设置到当前线程中，如果已经持有则直接使用
                if (tl.get() == null) {
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = tl.get().parse("2018-02-28 21:42:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.submit(new ParseDate(i));
        }
    }
}
