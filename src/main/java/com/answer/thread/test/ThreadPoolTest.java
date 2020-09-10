package com.answer.thread.test;

import com.answer.thread.chapter3.c2.RejectThreadPoolDemo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/9/10 9:58 上午
 */
public class ThreadPoolTest {
    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup threadGroup;
        private final String namePrefix;

        public DefaultThreadFactory() {
            SecurityManager sm = System.getSecurityManager();
            this.threadGroup = sm != null ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-" + DefaultThreadFactory.poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(this.threadGroup, r, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()){
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY){
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }

    }
    private static ThreadPoolExecutor tp = new ThreadPoolExecutor(6,12,1000l, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100) , new DefaultThreadFactory() , new ThreadPoolExecutor.AbortPolicy());
}
