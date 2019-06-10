package com.answer.thread.chapter1and2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @descreption
 * @Author answer
 * @Date 2019/6/10 17 32
 */
public class AddThread implements Runnable{

    private ConcurrentHashMap<String, String> concurrentHashMap;

    public AddThread(ConcurrentHashMap<String , String> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i=i+2) {
            concurrentHashMap.put(Integer.toString(i), Integer.toBinaryString(i));
            System.out.println("size=" + concurrentHashMap.size());
        }
    }
}
