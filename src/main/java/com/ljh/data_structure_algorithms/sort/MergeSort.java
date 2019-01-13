package com.ljh.data_structure_algorithms.sort;

/**
 * @author liujiahan
 * @Title: MergeSort
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Created on 2019/1/13
 * @ModifiedBy:
 */
public class MergeSort {

    /**
     * 除于2的分
     * @param a
     * @param tempArray
     * @param left
     * @param right
     */
    private static void mergeSort(Integer[] a, Integer[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tempArray, left, center);
            mergeSort(a, tempArray, center + 1, right);
            merge(a, tempArray, left, center + 1, right);
        }
    }

    /**
     * 进行合并
     * @param a
     * @param temp
     * @param leftPos
     * @param rightPos
     * @param rightEnd
     */
    private static void merge(Integer[] a, Integer[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int temPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                temp[temPos++] = a[leftPos++];
            } else {
                temp[temPos++] = a[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            temp[temPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) {
            temp[temPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = temp[rightEnd];
        }
    }

    /**
     * 3-归并排序，分而治之,时间复杂度：O(N*logN)
     * @param a
     */
    public static void mergeSort(Integer[] a) {
        Integer[] temp = new Integer[a.length];
        mergeSort(a, temp, 0, a.length - 1);
    }
}
