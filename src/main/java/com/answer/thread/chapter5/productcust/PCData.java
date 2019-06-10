package com.answer.thread.chapter5.productcust;

/**
 * @author answer
 * @description
 * @create 2018/4/2 15:49
 **/
public class PCData {
    private final int intData;
    public PCData(int d) {
        intData = d;
    }

    public PCData(String d) {
        intData = Integer.valueOf(d);
    }


    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "intData=" + intData;
    }
}
