package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class BubbleSort extends SortingAlgorithms {
    @Override
    public void sort(int[] arr, int start, int end) {
        int n = end;
        boolean isSwaped;
        for (int i = start; i < end; i++) {
            isSwaped = false;
            for (int j = start; j+1<n-i; j++) { // 下标
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    isSwaped = true;
                }
            }
            if (!isSwaped){
                break;
            }
        }
    }
}
