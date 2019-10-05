package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public abstract class SortingAlgorithms {
    abstract void sort(int[] arr,int start, int end);

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
