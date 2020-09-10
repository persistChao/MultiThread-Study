package com.answer.sort;

/**
 *
 * 二分查找
 * @author answer
 * @version 1.0.0
 * @date 2020/9/4 12:59 下午
 */
public class ErfenSort {

    public static void main(String[] args) {
        int[] array = {-1,0,3,5,7,8,9};
        System.out.println(sort(array ,5));
    }

    public static int sort(int[] array , int x){
        int middle =0;
        int max = array.length -1;
        int low = 0;
        while (low <= max) {
            middle =( low+max)/2;
            if (x > array[middle]) {
                low = middle +1;
            } else if (x < array[middle]) {
                max = middle-1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
