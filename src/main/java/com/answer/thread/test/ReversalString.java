package com.answer.thread.test;

import java.util.Stack;

/**
 *
 * 反转字符串
 *
 * @author answer
 * @version 1.0.0
 * @date 2020/9/4 12:46 下午
 */
public class ReversalString {

    public static void main(String[] args) {
        String s = "I love java";
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <chars.length ; i++) {
            stack.push(String.valueOf(chars[i]));
        }

        //或者 !stack.isEmpty()
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}
