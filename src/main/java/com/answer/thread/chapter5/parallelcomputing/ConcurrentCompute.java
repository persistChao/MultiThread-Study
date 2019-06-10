package com.answer.thread.chapter5.parallelcomputing;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 计算(B+C)*B/2
 *
 * @author answer
 * @description
 * @create 2018/4/8 10:09
 **/
public class ConcurrentCompute {

    /**
     * p1的计算结果B+C
     */
    public static class Plus implements Runnable{
        public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();

        @Override
        public void run() {
            boolean run = true;
            while (run) {
                try {
                    Msg msg = bq.take();
                    msg.j = msg.i + msg.j;
                    Muitiply.bq.add(msg);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Muitiply implements Runnable {

        public static BlockingQueue<Msg>  bq = new LinkedBlockingQueue<>();


        @Override
        public void run() {
            boolean run = true;
            while (run) {
                try {
                    Msg msg = bq.take();
                    msg.i = msg.i * msg.j;
                    Div.bq.add(msg);
                }catch (InterruptedException e) {

                }
            }
        }
    }

    public static class Div implements Runnable {

        public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();

        @Override
        public void run() {
            boolean run = true;
            while ( run) {
                try {
                    Msg msg = bq.take();
                    msg.i = msg.i / 2;
                    System.out.println("结果 " + msg.orgStr + " = " + msg.i);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Plus()).start();
        new Thread(new Muitiply()).start();
        new Thread(new Div()).start();

        for (int i =1;i<=100;i++) {
            for (int j = 1;j<=100;j++) {
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
                Plus.bq.add(msg);
            }
        }
    }



}
