package com.answer.thread.chapter3.c3;

import java.util.LinkedList;

/**
 * @author answer
 * @description
 * LinkedList 是一个继承于AbstractSequentialList的双向链表。它也可以被当作堆栈、队列或双端队列进行操作。
 LinkedList 实现 List 接口，能进行队列操作。
LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。
ArrayList底层是由数组支持，而LinkedList 是由双向链表实现的，其中的每个对象包含数据的同时还包含指向链表中前一个与后一个元素的引用。
 * @create 2018/2/27 11:20
 **/
public class TestLinkedList {
    public static void main(String[] srgs) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        /************************** 基本操作 ************************/
        linkedList.addFirst(0);    // 添加元素到列表开头
        linkedList.add(1);         // 在列表结尾添加元素
        linkedList.add(2, 2);       // 在指定位置添加元素
        linkedList.addLast(3);     // 添加元素到列表结尾

        System.out.println("LinkedList: " + linkedList);
        System.out.println("getFirst(): " + linkedList.getFirst());       // 返回此列表的第一个元素
        System.out.println("getLast(): " + linkedList.getLast());         // 返回此列表的最后一个元素
        System.out.println("removeFirst(): " + linkedList.removeFirst()); // 移除并返回此列表的第一个元素
        System.out.println("removeLast(): " + linkedList.removeLast());   // 移除并返回此列表的最后一个元素
        System.out.println("After remove:" + linkedList);
        System.out.println("contains(1) is :" + linkedList.contains(1));  // 判断此列表包含指定元素，如果是，则返回true
        System.out.println("size is : " + linkedList.size());             // 返回此列表的元素个数
    }
}
