package com.answer.thread.chapter1and2;/**
 * @Author: suchao
 * @Description:
 * @Date Create in 10:38 2017/12/7
 * @Modified by:
 */

import org.junit.Test;

/**
 * @author Administrator
 * @description
 * @create 10:38
 **/
public class ThreadTest {

    @Test
    public void testThreadNew() {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("hello i am  thread t1" );
            }
        };
        t1.start();
    }
}
