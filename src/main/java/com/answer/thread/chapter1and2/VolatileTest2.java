package com.answer.thread.chapter1and2;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/6/19 2:55 下午
 **/
public class VolatileTest2 {

    int a = 1;
    int b =2;

    public void change() {
        a = 3;
        b = a;
    }

    public void print(){
        System.out.println("b="+b + ";a="+a);
    }

    public static void main(String[] args) {
        while (true) {
            final VolatileTest2 t = new VolatileTest2();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    t.change();

                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    t.print();
                }
            }).start();
        }
    }

}
