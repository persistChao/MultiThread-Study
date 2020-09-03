package com.answer.thread.test;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/3 9:14 上午
 */
public class PrintAB implements Runnable{

    private String name;
    private Object prev;
    private Object self;

    public PrintAB(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notifyAll();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        PrintAB pa = new PrintAB("A",c,a);
        PrintAB pb = new PrintAB("B",a,b);
        PrintAB pc = new PrintAB("C",b,c);

        new Thread(pa,"t1").start();
        Thread.sleep(10);
        new Thread(pb,"t2").start();
        Thread.sleep(10);
        new Thread(pc,"t3").start();
        Thread.sleep(10);
    }
}
