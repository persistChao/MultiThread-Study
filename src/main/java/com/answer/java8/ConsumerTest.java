package com.answer.java8;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/18 5:53 下午
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-f2");

        f.andThen(f2).accept("test");
        f.andThen(f).andThen(f).accept("test1");
    }


}
