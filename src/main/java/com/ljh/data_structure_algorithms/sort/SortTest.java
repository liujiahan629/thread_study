package com.ljh.data_structure_algorithms.sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * @author liujiahan
 * @Title: SortTest
 * @Copyright: Copyright (c) 2019
 * @Description: 算法排序的总结
 * @Created on 2019/1/13
 * @ModifiedBy:
 */
public class SortTest {

    /**
     * 1-1，插入排序的实现方式：时间复杂度O(n^2)
     *
     * @param arrayForSort
     */
    public static void insertionSort(Integer[] arrayForSort) {
        int j;

        for (int p = 1; p < arrayForSort.length; p++) {
            Integer temp = arrayForSort[p];
            for (j = p; j > 0 && temp.compareTo(arrayForSort[j - 1]) < 0; j--) {
                arrayForSort[j] = arrayForSort[j - 1];
            }
            arrayForSort[j] = temp;
        }
    }

    /**
     * 1-2，希尔排序，最坏时间复杂度：O(n^1.5)
     *
     * @param arrayForSort
     */
    public static void shellSort(Integer[] arrayForSort) {
        int j;

        for (int gap = arrayForSort.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrayForSort.length; i++) {
                Integer temp = arrayForSort[i];

                for (j = i; j > gap && temp.compareTo(arrayForSort[j - gap]) < 0; j -= gap) {
                    arrayForSort[j] = arrayForSort[j - gap];
                }
                arrayForSort[j] = temp;
            }
        }
    }

    /**
     * 希尔排序比插入排序效率高的原因：插入排序是相邻两个交换位置；希尔排序能够更快的让交换完成，是gap的位置
     * 生活中，我们排队也是，先大概的排然后再换，而不是一个一个比较着换。
     */






    public static void main(String[] args) {
        Integer[] array = {2, 5, 3, 8, 4, 9, 6,13,32,12,11,33,7,14};
        //1,插入排序
        //insertionSort(array);
        //2希尔排序
        //shellSort(array);
        //3,归并排序
        //MergeSort.mergeSort(array);
        //4,快速排序
        //QuickSort.quickSort(array);
        //5,堆排序
        //HeapSort.heapSort(array);
        //6,冒泡排序
        //QuickSort.maopaoSort(array);
        //7,简单选择排序
        HeapSort.selectSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "+");

        }
    }
}
