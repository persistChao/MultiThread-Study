package com.answer.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 字符串反转
 * 利用栈stack
 * Created by chao on 2018/8/25.
 */
public class StringReverse {
    @Test
    public void testStringReverse() {
        Stack stack = new Stack<>();
        String s = "how are you";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
