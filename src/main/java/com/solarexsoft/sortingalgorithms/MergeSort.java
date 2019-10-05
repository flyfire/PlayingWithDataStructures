package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class MergeSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        int low = start, high = end - 1, n = end - start;
        int[] tmp = new int[n];
        mergeSort(arr, low, high, tmp);
    }

    private void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = low,j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= high) tmp[k++] = arr[j++];
        System.arraycopy(tmp, 0, arr, low, k);
    }

    private void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = low + (high - low)/2;
            mergeSort(arr, low, mid, tmp);
            mergeSort(arr, mid+1, high, tmp);
            merge(arr, low, mid, high, tmp);
        }
    }
}
