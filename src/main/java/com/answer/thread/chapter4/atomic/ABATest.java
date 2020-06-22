package com.answer.thread.chapter4.atomic;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/6/19 6:42 下午
 **/
public class ABATest {
    private AtomicInteger a = new AtomicInteger(1);
    private AtomicReference<Integer> b = new AtomicReference<>(1);
    private static AtomicStampedReference<Integer> c = new AtomicStampedReference<>(100,1);

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,1);

    public static void main(String[] args) {
//        new Thread(() -> {
//            System.out.println("t1拿到的初始版本号:" + atomicStampedReference.getStamp());
//
//            //睡眠1秒，是为了让t2线程也拿到同样的初始版本号
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            atomicStampedReference.compareAndSet(100, 101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
//            atomicStampedReference.compareAndSet(101, 100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
//        },"t1").start();
//
//        new Thread(() -> {
//            int stamp = atomicStampedReference.getStamp();
//            System.out.println("t2拿到的初始版本号:" + stamp);
//
//            //睡眠3秒，是为了让t1线程完成ABA操作
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("最新版本号:" + atomicStampedReference.getStamp());
//            System.out.println(atomicStampedReference.compareAndSet(100, 2019,stamp,atomicStampedReference.getStamp() + 1) + "\t当前 值:" + atomicStampedReference.getReference());
//        },"t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-value="+c.getReference() + ";版本号为:" + c.getStamp());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c.compareAndSet(100, 101, c.getStamp(), c.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "-value=" + c.getReference() + ";版本号为:" + c.getStamp());
                c.compareAndSet(101, 100, c.getStamp(), c.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "-value=" + c.getReference() + ";版本号为:" + c.getStamp());
                System.out.println("value = " + c.getReference());
            }
        },"t1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = c.getStamp();
                System.out.println(Thread.currentThread().getName() + "-value=" + c.getReference() + ";版本号为:" + stamp);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("current value + 4  result = " + c.compareAndSet(100 ,2019 ,stamp , stamp+1) );
            }
        },"t2").start();


    }
    @Test
    public void testAtomicIntegerAndAtomicReference() {
        for (int i = 0; i <1000 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a.incrementAndGet();
                    Integer x = b.get();
                    b.compareAndSet(x, x + 1);
                }
            }).start();

        }
        System.out.println("a="+a + ",b="+b);
    }

    @Test
    public void testABA() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer x = a.get();
                System.out.println(Thread.currentThread().getName() +" a 当前值==" + x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.compareAndSet(x ,x+1);
                System.out.println(Thread.currentThread().getName() +" a 当前值===" + a.get());
                a.compareAndSet(a.get() ,1);
                System.out.println(Thread.currentThread().getName() + " a 当前值====" + a.get());
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Integer x = a.get();
                System.out.println(Thread.currentThread().getName() + " a 当前值==" + x);

            }
        }).start();
    }

    /**
     * 解决ABA问题
     */
    @Test
    public void testABASolve() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-value="+c.getReference() + ";版本号为:" + c.getStamp());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c.compareAndSet(100, 101, c.getStamp(), c.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "-value=" + c.getReference() + ";版本号为:" + c.getStamp());
                c.compareAndSet(101, 100, c.getStamp(), c.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "-value=" + c.getReference() + ";版本号为:" + c.getStamp());
                System.out.println("value = " + c.getReference());
            }
        },"t1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName() + "-value=" + c.getReference() + ";版本号为:" + c.getStamp());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("current value + 4  result = " + c.compareAndSet(100 ,2019 ,c.getStamp() , c.getStamp()+1) );
            }
        },"t2").start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
