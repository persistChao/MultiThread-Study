package com.answer.tree;

/**
 * Created by chao on 2018/8/25.
 */
public class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public void display() {
        System.out.println(data);
    }
}
