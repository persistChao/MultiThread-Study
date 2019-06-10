package com.answer.tree.redblack;


/**
 * Created by chao on 2018/8/25.
 */
public class RBTree<T extends Comparable<T>> {
    private RBNode<T> root;


    private void leftRotate(RBNode<T> x) {
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        y.parent = x.parent;
        //如果x父节点为null 则说明x是root节点
        if (x.parent == null) {
            this.root = y;//设置y为root
        } else {
            //如果x父节点不为空 切x是x.parent 的左节点则设置如下
            if(x == x.parent.left){//如果x是左子节点
                x.parent.left = y;//则也将y设为左子节点
            }else{
                x.parent.right = y;//否则将y设为右子节点
            }
        }
        //3. 将y的左子节点设为x，将x的父节点设为y
        y.left = x;
        x.parent = y;
    }

    /*************对红黑树节点y进行右旋操作 ******************/
/*
 * 左旋示意图：对节点y进行右旋
 *        p                   p
 *       /                   /
 *      y                   x
 *     / \                 / \
 *    x  ry   ----->      lx  y
 *   / \                     / \
 * lx  rx                   rx ry
 * 右旋做了三件事：
 * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
 * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
 * 3. 将x的右子节点设为y，将y的父节点设为x
 */
    public void rightRotate(RBNode<T> y) {
        RBNode<T> x = y.right;
        y.left = x.right;

        if (x.right != null) {
            x.right.parent = y;
        }
        y.parent = x;
        x.right = y;

        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;
        }else {
            if (y == y.parent.left) {
                y.parent.left = x;
            }else {
                y.parent.right = x;
            }
        }
    }
}
