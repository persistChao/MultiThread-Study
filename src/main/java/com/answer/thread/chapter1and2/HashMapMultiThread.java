package com.answer.thread.chapter1and2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author answer
 * @description 多线程下的HashMap
 * @create 2018/2/12 10:04
 **/
public class HashMapMultiThread {

    static Map<String , String> map = new HashMap<>();
    static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    public static class AddThread implements Runnable {

        int start = 0;
        public AddThread(int start) {
            this.start = start;
        }
        @Override
        public void run() {
            for (int i = 0; i < 30 ; i++) {
                map.put(Integer.toString(i) , Integer.toBinaryString(i));
                System.out.println("size=" + map.size());
                concurrentHashMap.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new HashMapMultiThread.AddThread(0));
        Thread t2 = new Thread(new HashMapMultiThread.AddThread(1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
