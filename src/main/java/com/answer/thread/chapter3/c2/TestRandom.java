package com.answer.thread.chapter3.c2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author answer
 * @description
 * @create 2018/2/26 17:21
 **/
public class TestRandom {
    @Test
    public void testRandom() {
        Integer[] array = new Integer[400];
        fillRandom(array);
    }
    private static void fillRandom(Integer[] array) {
        for (int i =0 ; i< array.length ; i++) {
            int a = (int)(Math.random()*400+1);
            array[i] = a;
        }
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        for (int in : array) {
            System.out.println(in);
        }
    }
}
