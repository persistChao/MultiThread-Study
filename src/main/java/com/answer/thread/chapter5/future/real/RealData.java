package com.answer.thread.chapter5.future.real;

import java.util.concurrent.Callable;

/**
 * @author answer
 * @description
 * @create 2018/4/3 16:22
 **/
public class RealData implements Callable<String>{

    private String data;
    public RealData(String data) {
        this.data = data;
    }
    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i =0; i < 10; i++) {
            sb.append(data);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
