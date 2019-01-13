package com.ljh.data_structure_algorithms.sort;

/**
 * @author liujiahan
 * @Title: HeapSort
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Created on 2019/1/13
 * @ModifiedBy:
 */
public class HeapSort {
    /**
     * 简单选择排序
     */
    public static void selectSort(Integer[] a){
        for(int i = 1;i<a.length;i++){
            int temp =i;
            for(int j=i+1;j<a.length;j++){
                if(a[temp]>a[j]){
                    temp = j;
                }
            }
            swapReferences(a,temp,i);
        }
    }





    /**
     * 堆排序
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }


    private static void percDown(Integer[] a, int i, int n) {
        int child;
        Integer temp;

        for (temp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
                if (temp.compareTo(a[child]) < 0) {
                    a[i] = a[child];
                } else {
                    break;
                }
            }
        }
        a[i] = temp;
    }

    public static void swapReferences(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(Integer[] a) {
        for (int i = (a.length / 2) - 1; i >= 0; i--) {
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0,i);
            percDown(a, 0, i );
        }
    }
}
