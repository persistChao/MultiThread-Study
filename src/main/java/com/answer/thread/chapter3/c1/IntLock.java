package com.answer.thread.chapter3.c1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author answer
 * @description lock 与 lockInterruptibly比较区别在于：
 * lock 优先考虑获取锁，待获取锁成功后，才响应中断。
 * lockInterruptibly 优先考虑响应中断，而不是响应锁的普通获取或重入获取。
 * @create 2018/2/12 11:24
 **/
public class IntLock implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;
    /**
     * 控制加锁顺序 ， 方便构造死锁
     *
     */
    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                //lock 与 lockInterruptibly比较区别在于：
                //lock 优先考虑获取锁，待获取锁成功后，才响应中断。
                //lockInterruptibly 优先考虑响应中断，而不是响应锁的普通获取或重入获取。
                //中断进行相应的锁申请的动作 在等待锁的过程中可以响应中断
                lock1.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
                System.out.println("t1完成工作");
            }else {
                //由于主线程中 t2设置终断 所以 t2线程释放lock2 同时 放弃lock1的申请
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
                System.out.println("t2完成工作");
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "线程退出");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1 , "t1");
        Thread t2 = new Thread(r2 , "t2");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        //中断其中一个线程
        t2.interrupt();
    }
}
