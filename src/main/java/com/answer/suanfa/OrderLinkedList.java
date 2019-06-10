package com.answer.suanfa;

/**
 * 有序链表
 * Created by chao on 2018/8/24.
 */
public class OrderLinkedList {
    private Node head;

    public OrderLinkedList() {
        head = null;
    }

    //插入节点，并按照从小打到的顺序排列
    public void insert(int value) {
        Node node = new Node(value);
        Node pre = null;
        Node current = head;
        //value = 6
        // 5 4 3 9 2
        while (current != null && value > current.data) {
            pre = current;
            current = current.next;
        }
        if (pre == null) {
            head = node;
            head.next = current;
        } else {
            pre.next = node;
            node.next = current;
        }
    }

    //删除头节点
    public void deleteHead() {
        head = head.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        OrderLinkedList orderLinkedList = new OrderLinkedList();
        orderLinkedList.insert(6);
        orderLinkedList.insert(5);
        orderLinkedList.insert(8);
        orderLinkedList.insert(1);
        orderLinkedList.display();
    }
}
