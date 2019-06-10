package com.answer.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by chao on 2018/8/25.
 */
public class MyStack {
    private int[] array;
    private int maxSize;
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            array[++top] = value;
        }
    }

    public int pop() {
        return array[top--];
    }

    //访问栈顶数据
    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("statck size is " + stack.maxSize );
        System.out.println("栈顶元素：" + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());;
        }


    }
}
