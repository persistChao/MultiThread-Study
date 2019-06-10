package com.answer.thread.chapter1and2;


/**
 * @author suchao
 * @description
 * @create Create in 11:30 2017/12/7
 **/
public class CreatThread implements Runnable{
    @Override
    public void run() {
        System.out.println("oh , i am runnable!");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new CreatThread());
        t.start();
    }
}
