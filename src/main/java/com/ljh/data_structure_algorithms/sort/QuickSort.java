package com.ljh.data_structure_algorithms.sort;

/**
 * @author liujiahan
 * @Title: QuickSort
 * @Copyright: Copyright (c) 2019
 * @Description:
 * @Created on 2019/1/13
 * @ModifiedBy:
 */
public class QuickSort {

    /**
     * 大于10用快速排序，小于10用插入排序
     */
    private static final Integer CUTOFF=10;

    /**
     * 快速排序 时间复杂度：O(n*logn)
     * @param a
     */
    public static void quickSort(Integer[] a){
        quickSort(a,0,a.length-1);
    }


    private static void quickSort(Integer[] a ,int left,int right){
        if(left + CUTOFF<=right){
            Integer pivot = median3(a,left,right);

            //开始 partition
            int i = left,j=right-1;
            for(;;){
                while (a[++i].compareTo(pivot)<0){

                }
                while (a[--j].compareTo(pivot)>0){

                }
                if(i<j){
                    swapReferences(a,i,j);
                }else{
                    break;
                }
            }

            swapReferences(a,i,right-1);
            quickSort(a,left,i-1);
            quickSort(a,i+1,right);
        }else{
            SortTest.insertionSort(a);
        }

    }

    private static Integer median3(Integer[] a, int left,int right){
        int center = (left + right)/2;
        if(a[center].compareTo(a[left])<0){
            swapReferences(a,left,center);
        }
        if(a[right].compareTo(a[left])<0){
            swapReferences(a,left,right);
        }
        if(a[right].compareTo(a[center])<0){
            swapReferences(a,center,right);
        }
        swapReferences(a,center,right-1);
        return a[right-1];
    }

    /**
     * 交换数组的两个值
     * @param arr
     * @param i
     * @param j
     */
    public static void swapReferences(Integer[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 冒泡排序
     */
    public static void maopaoSort(Integer[] a ){
        for(int i = 1;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    swapReferences(a,j,j+1);
                }
            }
        }
    }
}
