package com.answer.thread.chapter3.c2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author answer
 * @description 在线程池中寻找堆栈
 * @create 2018/2/26 11:33
 **/
public class DivTask implements Runnable{
    int a , b ;
    public DivTask(int a , int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0 , Integer.MAX_VALUE , 0L , TimeUnit.MILLISECONDS ,
                new SynchronousQueue<Runnable>());
        for (int i = 0 ; i < 5 ; i++) {
            //使用submit提交 打印只有四个结果 当100/0 时候的结果并没有打印 线程池将异常信息吃掉
//            pools.submit(new DivTask(100 , i));
            //使用execute会抛出 by zero的异常
           pools.execute(new DivTask(100 , i));
//            Future re = pools.submit(new DivTask(100 , i));
//            re.get();
        }
    }
}
