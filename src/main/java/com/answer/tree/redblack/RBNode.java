package com.answer.tree.redblack;

/**
 * Created by chao on 2018/8/25.
 */
public class RBNode<T extends Comparable<T>> {

    boolean color;
    T key;//关键值
    RBNode<T> left;//左子节点
    RBNode<T> right;//右子节点
    RBNode<T> parent;

    public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    /**
     * 获得节点关键值
     * @return
     */
    public T getKey() {
        return key;
    }

    //打印节点的关键值和颜色信息
    public String toString(){
        return ""+key+(this.color);
    }
}
