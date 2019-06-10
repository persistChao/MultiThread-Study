package com.answer.thread.chapter5.parallelcomputing;

import org.junit.Test;

public class ConcurrentSort {

    @Test
    public void testSort() {

    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void  bubble(int arr[]) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j +1];

                }
            }
        }
    }
}
