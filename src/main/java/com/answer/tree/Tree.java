package com.answer.tree;

/**
 * 二叉树接口
 * Created by chao on 2018/8/25.
 */
public interface Tree {
    //查找节点
    public Node find(int key);

    //插入节点
    public boolean insert(int key);

    //delete node
    public boolean delte(Object key);

    //中序遍历
    public void infixOrder(Node current);

    //前序遍历
    public void preOrder(Node current);

    //后续遍历
    public void postOrder(Node curernt);

    //查找最大值
    public Node findMax();

    //查找最小值
    public Node findMin();
}
