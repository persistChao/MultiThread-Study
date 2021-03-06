package com.answer.thread.chapter3.c2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author answer
 * @description
 * @create 2018/2/26 15:34
 **/
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private static final int THREAD_HOLD = 2;

    private int start;

    private int end;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算
        boolean canCompute = (end - start) <= THREAD_HOLD;
        if (canCompute) {
            for (int i = start ; i <= end; i++) {
                sum += i;
            }
        }else {
            int midlle = (start + end)/2;
            System.out.println( "当前 midlle=" + midlle + " (4+1)/2="+((4+1)/2));
            ForkJoinDemo left = new ForkJoinDemo(start , midlle);
            ForkJoinDemo right = new ForkJoinDemo(midlle+1 , end);
            //执行子任务
            left.fork();
            right.fork();
            //获取子任务结果
            int lResult = left.join();
            int rResult = right.join();
            sum = lResult + rResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(1 , 4);
        Future<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
