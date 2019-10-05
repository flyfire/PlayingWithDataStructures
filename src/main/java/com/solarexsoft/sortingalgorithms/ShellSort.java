package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class ShellSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        int gap = (end - start) >> 1;
        for (; gap > 0; gap>>=1) {
            for (int i = gap; i < end; i++) {
                int j = i;
                int cur = arr[i];
                while (j-gap >= start && arr[j-gap] > cur) {
                    swap(arr, j, j-gap);
                    j = j-gap;
                }
                if (j != i) {
                    arr[j] = cur;
                }
            }
        }
    }
}
