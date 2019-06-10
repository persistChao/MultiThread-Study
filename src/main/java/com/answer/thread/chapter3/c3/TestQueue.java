package com.answer.thread.chapter3.c3;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author answer
 * @description
 * java.util.Queue 测试 add 增加一个元索 如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 *　remove 移除并返回队列头部的元素  如果队列为空，则抛出一个NoSuchElementException异常
 *　element 返回队列头部的元素       如果队列为空，则抛出一个NoSuchElementException异常
 *　offer添加一个元素并返回true      如果队列已满，则返回false
 *　poll 移除并返问队列头部的元素    如果队列为空，则返回null
 *　peek 返回队列头部的元素          如果队列为空，则返回null
 *　put  添加一个元素                如果队列满，则阻塞
 *　take 移除并返回队列头部的元素    如果队列为空，则阻塞
 * @create 2018/2/27 11:04
 **/
public class TestQueue {
    //定义一个队列
    Queue<String> queue;

    @Before
    public void before() {
        queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
    }

    //poll方法移除首个元素并返回，若队列为空，返回null
    @Test
    public void testPoll() {
        //弹出元素 。移除并返问队列头部的元素    如果队列为空，则返回null
        String pollElement = queue.poll();
        System.out.println(pollElement);
        System.out.println(queue);
    }

    //remove移除首个元素并返回，若队列为空，会抛出异常：NosuchElementException
    @Test
    public void testRemove() {
        //移除的元素
        String removeElem = queue.remove();
        System.out.println(removeElem);
        System.out.println(queue);
    }

    //peek方法返回队列首个元素 ,但不移除，若队列为空，返回null
    @Test
    public void testPeek() {
        //返回首个元素
        queue.poll();
        queue.remove();
        String peekElem = queue.peek();
        System.out.println(peekElem);
        System.out.println(queue);
    }

    //element 返回队列的头元素，但不移除，若队列为空，会抛出异常，NosuchElementException
    @Test
    public void testElement() {
        //查看首个元素
        String element = queue.element();
        System.out.println(element);
        System.out.println(queue);
    }


}
