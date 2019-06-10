package com.answer.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    private static  List<Integer> pool = Arrays.asList(3,5,6,7,20,10,5,0);

    private static CopyOnWriteArrayList pool2 = new CopyOnWriteArrayList(pool);

    private static CopyOnWriteArrayList<Integer> zjlist = new CopyOnWriteArrayList<>();

    public static class Qhb implements Runnable{

        @Override
        public void run() {
//            if (pool.size() > 0) {
//                int index =(int) (Math.random() * pool.size());
//                zjlist.add(pool.get(index));
//                pool.remove(index);
//            }

            if (pool2.size() > 0) {
                int index = (int)(Math.random()* pool2.size());
                zjlist.add((int)pool2.get(index));
                pool2.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            Qhb q = new Qhb();
            service.submit(q);
        }
        System.out.println("抢到的红包个数" + zjlist.size());
        System.out.println("Pool剩余个数：" + pool2.size());
        System.out.println(zjlist.toArray().toString());
    }


}
