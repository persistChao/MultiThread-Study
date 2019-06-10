package com.answer.suanfa;

/**
 * 双端链表
 * Created by chao on 2018/8/24.
 */
public class DoublePointLinkedList {
    //首端 first
    private Node head;
    //尾端 last
    private Node tail;

    private int size;

    public DoublePointLinkedList () {
        size = 0;
        head = null;
        tail = null;
    }

    public void addHead(Object o) {
        Node node = new Node(o);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
            size++;
        }
    }

    //链表尾端增加节点
    public void addTail(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public boolean delteHead() {
        if (size == 0) {
            return false;
        }

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }




    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
