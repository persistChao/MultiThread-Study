package com.answer.thread.chapter5.future;

/**
 * FutureData是realData的封装
 * @author answer
 * @description
 * @create 2018/4/3 15:47
 **/
public class FutureData implements Data {
    protected RealData realData = null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return ;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    public synchronized String getResult() {
        while (!isReady) {
            try {
                //一直等待直到RealData被注入
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }
}
