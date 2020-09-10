package com.answer.thread.test;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/7 5:03 下午
 */
public class ThreadOut implements Runnable {

    public   volatile  boolean isRun = true;


    @Override
    public void run() {
        while (isRun) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 线程的状态为：" + Thread.currentThread().getState());
        }
        System.out.println(Thread.currentThread().getName() +  " run 方法退出while 循环...");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadOut to = new ThreadOut();
        System.out.println("isRun === " + to.isRun );
        Thread t = new Thread(to);
        t.setName("t1");
        System.out.println("子线程t1 start/...");
        t.start();
        Thread.sleep(2000);
        System.out.println("设置isRun is false....");
        to.isRun = false;
        System.out.println("isRun is  " + to.isRun);

    }
}
