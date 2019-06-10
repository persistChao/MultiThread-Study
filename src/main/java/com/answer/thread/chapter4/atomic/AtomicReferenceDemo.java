package com.answer.thread.chapter4.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 无锁的对象
 * Created by chao on 2018/3/17.
 */
public class AtomicReferenceDemo {
    public static AtomicReference<Integer> money = new AtomicReference<Integer>();
    //设置账户初始值小于20 ， 显然这是一个需要被充值的账户
    public static void main(String[] args) {
        money.set(19);
        //模拟多个线程同事腾信后台数据库,为用户充值
        for (int i = 0; i < 3;i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.get();
                            if (m < 20) {
                                if(money.compareAndSet(m , m+20)) {
                                    System.out.println("余额小于20元，充值成功，余额：" + money.get() + "元");
                                    break;
                                }
                            }else {
                                break;
                            }
                        }
                    }
                }
            }.start();
        }
        new Thread() {
            public void run () {
                for (int i = 0; i <100; i++) {
                    while(true) {
                        Integer m = money.get();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10)) {

                                System.out.println("成功消费10元，余额：" + money.get());
                                break;
                            }
                        }else {
                            System.out.println("没有足够的金额");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e) {}
                }
            }
        }.start();
    }
}
