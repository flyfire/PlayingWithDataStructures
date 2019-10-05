package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class QuickSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        lomutoSort(arr, start, end - 1);
    }

    private int lomutoParation(int arr[],int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private void lomutoSort(int arr[], int low, int high) {
        if (low < high) {
            int k = lomutoParation(arr, low, high);
            lomutoSort(arr, low, k-1);
            lomutoSort(arr, k+1, high);
        }
    }
}
