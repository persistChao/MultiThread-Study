package com.answer.thread.chapter1and2;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author answer
 * @description 多线程下的ArrayList  应该用Vector 替代
 * @create 2018/2/12 9:55
 **/
public class ArrayListMultiThread {

    static ArrayList<Integer> al = new ArrayList<>(10);

//    static Vector<Integer> vt = new Vector<>();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0 ; i < 1000000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread( new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());
    }
}
