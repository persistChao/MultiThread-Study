package com.answer.thread.chapter5.parallelcomputing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用并行搜索
 * @author answer
 * @description
 * @create 2018/4/8 11:02
 **/
public class ConcurrentSearch {
    static int[] arr;
    //定义线程池
    static ExecutorService pool = Executors.newCachedThreadPool();
    //
    static final int Thread_Num = 2;
    //结果result 符合条件的元素的下标会保存在result中
    static AtomicInteger result = new AtomicInteger(-1);

    /**
     * 首先判断是否有其他线程找到了结果，如果找到直接返回
     * 如果没找到则进一步搜索
     * @param searchValue
     * @param beginPos
     * @param endPos
     * @return
     */
    public static int search(int searchValue , int beginPos , int endPos) {
        int i = 0;
        for (i = beginPos;i<endPos;i++) {
            if (result.get() >= 0) {
                return result.get();
            }
            //如果已经找到了需要的数据，则将结果保存到result中
            if (arr[i] == searchValue) {
                //如果设置失败，表示其他线程已经找到了
                //使用CAS操作，如果设置失败，则表示其他线程已经先一步找到了结果，所以可以无视失败的情况，找到结果并返回
                if (!result.compareAndSet(-1 , i)) {
                    return result.get();
                }
                return i;
            }
        }
        return -1;
    }

    /**
     * 定义一个线程进行查找，它会调用前面的pSearch()方法
     */
    public static class SearchTask implements Callable<Integer> {
        int begin , end ,searchValue;
        public SearchTask (int searchValue , int begin , int end ) {
            this.begin = begin;
            this.end = end;
            this.searchValue = searchValue;
        }
        public Integer call() {
            int re = search(searchValue , begin , end);
            return re;
        }
    }

    /**
     * 查找函数，他会根据线程数量对arr数组进行划分，并建立对应的任务提交给线程
     */
    public static int pSearch(int searchValue) throws InterruptedException , ExecutionException{
        int subArrSize = arr.length/Thread_Num;
        List<Future<Integer>> re = new ArrayList<>();
        for (int i = 0; i < arr.length; i ++) {
            int end = i + subArrSize;
            if (end >= arr.length) {
                end = arr.length;
            }
            re.add(pool.submit(new SearchTask(searchValue,i , end)));
        }
        for (Future<Integer> fu : re) {
            if (fu.get()>=0 ) {
                return fu.get();
            }
        }
        return -1;
    }

}
