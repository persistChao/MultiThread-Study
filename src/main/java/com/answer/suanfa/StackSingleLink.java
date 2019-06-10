package com.answer.suanfa;

/**
 * 用单向链表实现栈
 * Created by chao on 2018/8/24.
 */
public class StackSingleLink {
    private SingleLinkedList link;

    public StackSingleLink() {
        link = new SingleLinkedList();
    }

    public void push(Object object) {
        link.addHead(object);
    }

    //移除栈顶元素
    public Object pop() {
        Object o = link.deleteHead();
        return o;
    }

    public boolean isEmpty() {
        return link.isEmpty();
    }

}
