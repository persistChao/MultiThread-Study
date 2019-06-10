package com.answer.sort;

/**
 * 选择排序
 * Created by chao on 2018/8/25.
 */
public class ChoiceSort {
    public static int[] sort(int[] array) {
        //共比较N-1次
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            //每轮需要比的次数
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            //将找到最小的和min调换
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            //第i轮排序结果
            System.out.println("第" + (i+1) + "轮排序结果为" );
            display(array);
        }
        return array;

    }

    //遍历显示数组
    public static void display(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] array = {4,2,8,9,5,7,6,1,3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过选择排序后的数组顺序为：");
        display(array);
    }
}
