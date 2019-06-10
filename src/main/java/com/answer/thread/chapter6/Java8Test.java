package com.answer.thread.chapter6;

import org.junit.Test;

import java.util.Arrays;

public class Java8Test {
    /**
     * 将数组判断是否是奇数，如果是则执行加1
     */
    @Test
    public void testFor() {
        int[] arr = {1, 2, 3, 4, 7, 8, 9, 10};
        for (int i = 0; i < arr.length; i++) {
            if (i%2!=0) {
                arr[i]++;
            }
            System.out.println(arr[i]);
        }

        //=============分割线=====================
        System.out.println("=============分割线=====================");
        Arrays.asList(arr);

    }
}
