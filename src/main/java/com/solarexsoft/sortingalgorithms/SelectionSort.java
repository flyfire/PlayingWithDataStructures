package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class SelectionSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            int min = arr[i];
            int j = i+1;
            int minIndex = i;
            for (; j < end; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j]; // 记得更新最小值
                }
            }
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }
}
