package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class ShakerSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        int left = start, right = end - 1;
        boolean isSwapped = false;
        while (left < right) {
            isSwapped = false;
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    isSwapped = true;
                }
            }
            right--;

            if (!isSwapped) {
                break;
            }

            for (int i = right; i > left ; i--) {
                if (arr[i-1] > arr[i]){
                    swap(arr, i, i-1);
                    isSwapped = true;
                }
            }
            left++;
            if (!isSwapped) {
                break;
            }
        }
    }
}
