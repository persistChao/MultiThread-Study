package com.answer.thread.chapter5.future.real;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author answer
 * @description
 * @create 2018/4/3 16:24
 **/
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //构造FutureTask
        FutureTask<String> future = new FutureTask<>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //执行FutureTask 相当于模拟案例中的 client.request("a");发送请求
        //在这里开启线程进行RealData的call执行
        executor.submit(future);
        System.out.println("请求完毕");
        System.out.println("==== is Done " + future.isDone() + "-======");
        try {
            //这里依然可以做额外的数据操作，这里使用sleep代替其他业务逻辑的处理
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //相当于模拟案例中的data.gerResult() 去的call()方法返回值
        //如果此时call()方法没有执行完成，则依然会等待
        if (future.isDone()) {
            executor.shutdown();
        }
        System.out.println("==== is Done " + future.isDone() + "-======");
        System.out.println("数据：" + future.get());
    }
}
