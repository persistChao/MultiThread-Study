package com.answer.thread;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {

    static List<Integer> al = Arrays.asList(3,5,6,7,20,10,5,0);


    static Vector<Integer> v1 = new Vector<>(al);
    static Vector<Integer> vt = new Vector<>();

    static class Qhb implements Runnable{

        @Override
        public void run() {
            if (v1.size() > 0) {
                int index = (int)(Math.random() * v1.size());
                vt.add(v1.get(index));
                v1.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            Qhb q = new Qhb();
            service.submit(q);
        }
        System.out.println("中奖的人数为：" + vt.size());
        System.out.println("pool中剩余的个数为:" + v1.size());

    }
}
