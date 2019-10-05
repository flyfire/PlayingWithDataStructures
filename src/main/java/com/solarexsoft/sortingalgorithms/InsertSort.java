package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class InsertSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            int tmp = arr[i];
            int j = i;
            for (; j - 1 >= start && arr[j-1] > tmp; j--) { // 记得终止条件
                swap(arr, j, j - 1);
            }
            if (j != i) {
                arr[j] = tmp;
            }
        }
    }
}
