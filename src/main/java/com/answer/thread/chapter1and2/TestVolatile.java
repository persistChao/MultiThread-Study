package com.answer.thread.chapter1and2;/**
 * @Author: suchao
 * @Description:
 * @Date Create in 10:48 2017/12/11
 * @Modified by:
 */

/**
 * @author Administrator
 * @description
 * @create 10:48
 **/
public class TestVolatile {
    private static volatile int i = 0;
    public static class PlusTask implements Runnable{

        public void run() {
            for (int k=0 ; k < 1000 ; k++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0 ; i < 10; i++ ) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }
        for (int i =0 ;i < 10 ; i++) {
            threads[i].join();
        }
        System.out.println(i);
    }
}
