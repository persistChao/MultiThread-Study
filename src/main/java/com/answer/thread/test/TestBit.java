package com.answer.thread.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/10 2:52 下午
 */
public class TestBit {
    public static void main(String[] args) {
        String key = "name";
        String value = "阿三";
        System.out.println("key's hash = " + hash(key));
//        System.out.println("value's hash =" + hash(value));

    }

    static int hash(Object key) {
        int h;
        System.out.println(key + "的hashcode=" + key.hashCode());
        System.out.println("h = " + key.hashCode());
        h = key.hashCode();
        System.out.println("h>>>16 = " + (h>>>16));
        int x = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println("h ^ (h>>>16) = " + x);
        return  x;
    }
}
