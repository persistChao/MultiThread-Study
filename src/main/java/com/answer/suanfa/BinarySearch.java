package com.answer.suanfa;

/**
 * 二分查找(折半算法)
 * Created by chao on 2018/8/23.
 */
public class BinarySearch {

    /**
     * 使用递归
     * @param arry
     * @param key
     * @param low
     * @param heigh
     * @return
     */
    public static int binarySearch1(int arry[] , int key , int low ,int heigh) {
        if (arry[low] > key || arry[heigh] < key) {
            return -1;
        }

        int middle = (low + heigh) / 2;
        if (arry[middle] > key) {
           return  binarySearch1(arry, key, low, middle - 1);
        } else if (arry[middle] < key) {
            return binarySearch1(arry, key, middle + 1, heigh);
        } else {
            return middle;
        }
    }

    public static int binnarySearch2(int arry[] , int key) {
        int low = 0;
        int heigh = arry.length - 1;
        int middle = 0;

        if (low > heigh || key < arry[low] || key > arry[heigh]) {
            return -1;
        }
        while (low <= heigh) {
            middle = (low + heigh) / 2;
            if (key > arry[middle]) {
                low = middle + 1;
            } else if (key < arry[middle]) {
                heigh = middle - 1;
            } else {
                return middle;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int arry[] = {3,5,8,22,32,44,46,56,78,90};
//        int result = binarySearch1(arry , 8 , 0 , arry.length-1);
        int result = binnarySearch2(arry, 32);
        System.out.println(result);

        System.out.println(5 & 19);



    }
}
