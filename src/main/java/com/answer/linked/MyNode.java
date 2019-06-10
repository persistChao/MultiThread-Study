package com.answer.linked;

/**
 * Created by chao on 2018/9/6.
 */
public class MyNode {

    public class Node{
        int index;
        Node next;

        public Node(int index, Node next) {
            this.index = index;
            this.next = next;
        }
    }

    //迭代法。先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点
    public Node reverse(Node node) {
        Node prev = null;
        Node now = node;
        while (now != null) {
            Node next = now.next;
            prev = now;
            now = next;
        }
        return prev;
    }
}
