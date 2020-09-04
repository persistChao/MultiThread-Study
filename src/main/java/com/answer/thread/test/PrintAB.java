package com.answer.thread.test;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/3 9:14 上午
 */
public class PrintAB implements Runnable{

    private final String name;
    private final Object prev;
    private final Object self;

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
//        Object a = new Object();
//        Object b = new Object();
//        Object c = new Object();
//        PrintAB pa = new PrintAB("A",c,a);
//        PrintAB pb = new PrintAB("B",a,b);
//        PrintAB pc = new PrintAB("C",b,c);
//
//        new Thread(pa,"t1").start();
//        Thread.sleep(10);
//        new Thread(pb,"t2").start();
//        Thread.sleep(10);
//        new Thread(pc,"t3").start();
//        Thread.sleep(10);

        Printer p = new Printer();
        PrintA pa = new PrintA("a");
        PrintB pb = new PrintB("b");

        Thread t1 = new Thread(pa);
        Thread t2 = new Thread(pb);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        Thread.sleep(10);
        t2.start();
    }


    public static class Printer implements  Runnable{

        private final Object object = new Object();
        int i =1;
        @Override
        public void run() {
            while (i<=100) {
                synchronized (object) {
                    object.notifyAll();
                    try {
                        Thread.sleep(115);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " = " + i);
                    i++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }

    private  static final Object obj = new Object();

    public static class PrintA implements Runnable{
        private String value ;


        public PrintA(String value){
            this.value = value;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (obj){
                    System.out.print(value);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static class PrintB implements Runnable{
        private String value ;


        public PrintB(String value){
            this.value = value;
        }

        @Override
        public void run() {
            while (true){
                synchronized (obj){
                    System.out.print(value);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
