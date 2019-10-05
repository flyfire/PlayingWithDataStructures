package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class SelectionSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            int j = i+1;
            int minIndex = i;
            for (; j < end; j++) {
                if (arr[j] < arr[minIndex]) { // 如果要保存min记得更新min
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }
}
