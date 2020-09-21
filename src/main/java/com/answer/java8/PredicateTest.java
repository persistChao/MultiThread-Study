package com.answer.java8;

import org.junit.Assert;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/21 4:00 下午
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> t = o->o.equals("test");
        Predicate<String> g = o -> o.startsWith("t");

        System.out.println(t.test("test1") );
        System.out.println(g.test("te"));

        //negate: 用于对原来的Predicate做取反处理；如当调用t.test("test")为True时，调用t.negate().test("test")就会是False；
        System.out.println(t.negate().test("test1"));

        //t和g都为true则整个返回true
        System.out.println(t.and(g).test("test1"));

        System.out.println(t.or(g).test("et"));

        Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        s.flatMap(n -> Stream.of(n.split(""))).forEach(System.out::println);

        Stream<String> st = Stream.of("test", "t1", "t2", "teeeee", "aaaa", "taaa");
        //以下结果将打印： "test", "t1", "t2", "teeeee"，最后的那个taaa不会进行打印
//        st.takeWhile(n -> n.contains("t")).forEach(System.out::println);

    }
}
