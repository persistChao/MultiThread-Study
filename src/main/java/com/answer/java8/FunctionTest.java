package com.answer.java8;

import java.util.function.Function;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/21 3:20 下午
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> f = s -> s+3;
        Function<Integer, Integer> g = s -> s * 2;

        //解释：先执行g方法 然后g的结果当做f的输入 输出：3
        System.out.println(f.compose(g).apply(1));

        //解释：使用f的输出结果作为g的输入
        System.out.println(f.andThen(g).apply(1));

        //identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
        System.out.println(Function.identity().apply("a"));

    }
}
