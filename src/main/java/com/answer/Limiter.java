package com.answer;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/7/30 3:57 下午
 */
public class Limiter {
    @Test
    public  void test() {
        /**
         * 创建一个限流器，设置每秒放置的令牌数：2个。速率是每秒可以2个的消息。
         * 返回的RateLimiter对象可以保证1秒内不会给超过2个令牌，并且是固定速率的放置。达到平滑输出的效果
         */
        RateLimiter r = RateLimiter.create(2);
        System.out.println(r.acquire(2));
        System.out.println(r.acquire(1));
        System.out.println(r.acquire(1));
        System.out.println(r.acquire(1));
        System.out.println(r.acquire(1));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(r.acquire(1));
        System.out.println(r.acquire(1));
        System.out.println(r.acquire(1));
//        while (true) {
//            System.out.println(r.acquire());
//        }
    }


}
