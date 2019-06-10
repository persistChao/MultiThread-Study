package com.answer.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 快速排序
 * Created by chao on 2018/8/23.
 */
public class QuickSort {

    public static int divide(int arry[], int start, int end) {
        int base = arry[end];
        while (start < end) {
            while (start < end && arry[start] <= base) {
                start++;
            }
            if (start < end) {
                int temp = arry[start];
                arry[start] = arry[end];
                arry[end] = temp;
                end--;
            }
            while (start < end && arry[end] >= base)
                //从右边开始遍历，如果比基准值大，就继续向左走
                end--;
            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if (start < end) {
                //交换
                int temp = arry[start];
                arry[start] = arry[end];
                arry[end] = temp;
                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                start++;
            }
        }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }

    /**
     * 排序
     *
     * @param a
     * @param start
     * @param end
     */
    public static void sort(int[] a, int start, int end) {
        if (start > end) {
            //如果只有一个元素，就不用再排下去了
            return;
        } else {
            //如果不止一个元素，继续划分两边递归排序下去
            int partition = divide(a, start, end);
            sort(a, start, partition - 1);
            sort(a, partition + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{2, 7, 4, 5, 10, 1, 9, 3, 8, 6};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] c = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] d = new int[]{1, 10, 2, 9, 3, 2, 4, 7, 5, 6};

        Map m = new HashMap(1);
        sort(a, 0, a.length - 1);

        System.out.println("排序后的结果：");
        for (int x : a) {
            System.out.print(x + " ");
        }
    }


}
