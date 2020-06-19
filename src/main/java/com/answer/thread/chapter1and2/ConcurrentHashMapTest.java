package com.answer.thread.chapter1and2;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @descreption
 * @Author answer
 * @Date 2019/6/10 18 00
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) throws InterruptedException {
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(1000);
//        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>(1000);
//        AtomicInteger integer = new AtomicInteger(1);
//        map.put("key", integer);
//        ThreadFactory testThreadFactory = new ThreadFactoryBuilder().setNameFormat("cchm-thread-pool-%d").build();
//        ExecutorService executor =
//                new ThreadPoolExecutor(100, 100, 0L,
//                        TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1000), testThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//        for (int i = 0; i <1000 ; i++) {
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
////                    int key = map.get("key") + 1 ;
////                    map.put("key", key);
//                    map.get("key").incrementAndGet();
//                }
//            });
//        }
//        Thread.sleep(1000);
//        System.out.println("-------- " + map.get("key") + "---------------");
//        executor.shutdown();
    }
}
