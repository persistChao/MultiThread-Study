package com.answer.thread.chapter1and2;/**
 * @Author: suchao
 * @Description:
 * @Date Create in 11:30 2017/12/7
 * @Modified by:
 */

/**
 * @author Administrator
 * @description
 * @create 11:30
 **/
public class CreatThread implements Runnable{
    public void run() {
        System.out.println("oh , i am runnable!");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new CreatThread());
        t.start();
    }
}
