package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class HeapSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        int sortEnd = end - 1;
        mergeSort(arr, start, sortEnd);
    }

    private void siftDown(int[] arr, int i, int end) {
        int parent = i, child = 2 * i + 1;
        while (child <= end) {
            if (child + 1 <= end && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            if (arr[parent] > arr[child]) {
                break;
            }
            swap(arr, parent, child);
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private void buildMaxHeap(int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;
        for (int i = mid; i >= start; i--) {
            siftDown(arr, i, end);
        }
    }

    private void mergeSort(int[] arr, int start, int end) {
        buildMaxHeap(arr, start, end);
        for (int i = end; i > start; i--) {
            swap(arr, start, i);
            siftDown(arr, start, i-1); // i-1 >= start
        }
    }
}
