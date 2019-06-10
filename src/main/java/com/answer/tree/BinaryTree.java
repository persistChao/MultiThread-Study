package com.answer.tree;

/**
 * Created by chao on 2018/8/25.
 */
public class BinaryTree implements Tree{
    private Node root;

    @Override
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {
                current = current.leftChild;
            } else if (current.data < key) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parent = null;
            while (current != null) {
                parent = current;
                if (current.data > key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public boolean delte(Object key) {
        return false;
    }

    @Override
    public void infixOrder(Node current) {
         if (current != null) {
            infixOrder(current.leftChild);
            System.out.println(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    @Override
    public void preOrder(Node current) {
        if (current != null) {
            System.out.println(current.data + " ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }

    }

    @Override
    public void postOrder(Node curernt) {
        if (curernt != null) {
            infixOrder(curernt.leftChild);
            infixOrder(curernt.rightChild);
            System.out.println(curernt.data + " ");
        }
    }

    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.infixOrder(bt.root);
//        bt.delete(10);//删除没有子节点的节点
//        bt.delete(30);//删除有一个子节点的节点
//        bt.delete(80);//删除有两个子节点的节点
        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));

    }
}
