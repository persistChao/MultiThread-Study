package com.answer.linked;

/**
 * Created by chao on 2018/9/6.
 */
public class NodeTransfer {

    public static class Node{
        int index;
        private Node next;

        public Node(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        //先反转后续节点，
        Node reHead = reverse(head.getNext());
        //让前一节点的指针指为null
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }

    public static Node reverse2(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        Node temp ;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur =temp;
        }
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        //打印反转前的列表
        Node h = head;
        while (null != h) {
            System.out.println(h.getIndex() + " ");
            h = h.getNext();
        }
        //调用反转的方法
//        head = reverse(head);
//        System.out.println("********************************");
//        while (head != null) {
//            System.out.println(head.getIndex() + " ");
//            head = head.getNext();
//        }

        System.out.println("\n 第二种 ***************");
        head = reverse2(head);
        while (head != null) {
            System.out.println(head.index + " ");
            head = head.next;
        }
    }



}
