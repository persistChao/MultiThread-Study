package com.answer.thread.chapter5.future.real;

import java.util.concurrent.*;

/**
 * 使用Callable+FutureTask获取执行结果
 * @author answer
 * @description
 * @create 2018/4/3 16:50
 **/
public class CallableTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executor.submit(futureTask);

        executor.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程正在执行");

        try {
            System.out.println("task运行结果 = " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程执行完毕");
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i< 100; i++) {
                sum +=i;
            }
            return sum;
        }
    }
}
