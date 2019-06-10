package com.answer.thread.chapter3.c1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author answer
 * @description condition
 * @create 2018/2/12 15:43
 **/
public class ReenterLockCondition implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            //使当前线程等待 并且会释放当前锁
            condition.await();
            System.out.println("Thread is going on");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition tl = new ReenterLockCondition();
        Thread t1 = new Thread(tl);
        t1.start();
        Thread.sleep(2000);
        //通知线程t1 继续执行
        //signal 唤醒锁之前先获取当前锁 然后使其继续执行 await 和 signal是和lock一起使用的 必须先获取lock才能使用
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
