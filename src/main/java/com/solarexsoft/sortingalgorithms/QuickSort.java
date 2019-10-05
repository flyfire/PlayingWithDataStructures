package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class QuickSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
//        lomutoSort(arr, start, end - 1);
        hoareSort(arr, start, end - 1);
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

    private int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low + (high-low)/2];
        int i = low, j = high;
        while (true) {
            while (arr[i] < pivot) ++i;
            while (arr[j] > pivot) --j;
            if (i >= j) return j;
            swap(arr, i++, j--);
        }
    }

    private void hoareSort(int[] arr, int low, int high) {
        if (low < high) {
            int k = hoarePartition(arr, low, high);
            hoareSort(arr, low, k);
            hoareSort(arr, k+1, high);
        }
    }
}
