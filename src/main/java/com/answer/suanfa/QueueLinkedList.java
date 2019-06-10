package com.answer.suanfa;

/**
 * 双端列表实现队列
 * Created by chao on 2018/8/24.
 */
public class QueueLinkedList {

    private DoublePointLinkedList dp;

    public QueueLinkedList() {
        dp = new DoublePointLinkedList();
    }

    public void insert(Object data) {
        dp.addTail(data);
    }


}
