package com.answer.thread.chapter3.c3;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author answer
 * @description Lock锁的 等待与唤醒
 * @create 2018/2/28 15:06
 **/
public class AwaitSignal {

    private LinkedList<String> list = new LinkedList<>();
    private int MAX = 10;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    public class Producer implements Runnable {

        @Override
        public void run() {
            list.peek();
        }
    }
}
