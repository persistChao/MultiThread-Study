package com.answer.java8;

import java.util.Objects;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/18 5:47 下午
 */
public interface Consumer<T> {
    /**
     * 接收对象
     *
     * @param o obj
     */
    void accept(Object o);

    /**
     * 在当前方法完成后执行
     *
     * @param after 执行对象
     * @return Consumer
     */
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (t) -> {
            accept(t);
            after.accept(t);
        };
    }
}
