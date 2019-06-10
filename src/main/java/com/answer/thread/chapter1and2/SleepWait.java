package com.answer.thread.chapter1and2;

/**
 * @author answer
 * @description
 * @create 2018/3/20 10:13
 **/
public class SleepWait {
    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }

    public static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (SleepWait.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try {
                    SleepWait.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            synchronized (SleepWait.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                SleepWait.class.notify();
                //==================
                //区别
                //如果我们把代码：SleepWait.class.notify();给注释掉，SleepWait.class调用了wait()方法，但是没有调用notify()
                //方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }
}
