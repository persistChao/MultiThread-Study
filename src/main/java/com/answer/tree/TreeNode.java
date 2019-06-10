package com.answer.tree;

/**
 * Created by chao on 2018/8/25.
 */
public class TreeNode  {

    private Node root;

    //查找节点
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {
                current = current.leftChild;
            } else if (current.data < key) {
                current = current.rightChild;
            }else {
                return current;
            }
        }
        return null;
    }

    //插入数据
    public boolean insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parent = null;
            while (current != null) {
                parent = current;
                if (current.data > data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return true;
                    }
                } else if (current.data < data) {//当前值比root 或者父节点打 向右遍历
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return true;
                    }
                } else {
                    current = newNode;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delte(Object key) {
        return false;
    }

    //中序遍历 左子树->根节点->右子树
    public void infixOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            System.out.println(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    //前序遍历 根节点——》左子树——》右子树
    public void preOrder(Node current) {
        if (current != null) {
            System.out.println(" ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    //后序遍历
    public void postOrder(Node current){
        if(current != null){
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.data+" ");
        }
    }


    private class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
        }

        public void display() {
            System.out.println(data);
        }
    }
}
