package com.answer.thread.test;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/8 10:16 上午
 */
public class ThreadInterruptedTest implements Runnable {

    public static void main(String[] args) {
        ThreadInterruptedTest tit = new ThreadInterruptedTest();
        Thread t = new Thread(tit);
        t.start();
        try {
            Thread.sleep(2000);
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        try {
//            t.join();
            System.out.println("子线程中断后 睡眠2s");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("子线程被中断 异常被捕获 人工break");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " 的状态为 " + Thread.currentThread().getState());
            } else {
                System.out.println("线程被人工中断");
                break;
            }
        }
    }
}
