package com.solarexsoft.geektimedatastructure.sort;

/**
 * Created by houruhou on 2020/3/17.
 * Desc:
 */
public class SortingAlogrithmsImpl {
    public static void bubbleSort(int[] arr, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            boolean exchanged = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    exchanged = true;
                }
            }
            if (!exchanged) {
                break;
            }
        }
    }

    public static void insertionSort(int[] arr, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j>=0; j--){
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                }
            }
            arr[j+1] = value;
        }
    }

    public static void selectionSort(int[] arr, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            int pivot = arr[i];
            int index = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < pivot) {
                    pivot = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
    }

    public static void mergeSort(int[] arr, int n) {

    }
    public static void mergeSortC(int[] arr, int start, int end) {
        if (start >= end) return;
        int q = (start + end) / 2;
        mergeSortC(arr, start, q);
        mergeSortC(arr, q+1, end);
        merge(arr, start, q, end);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - (m + 1) + 1;

        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[k] = R[j];
            k++;
            j++;
        }
    }

    public static void quickSort(int[] arr, int n) {
        quickSortC(arr, 0, n-1);
    }

    public static void quickSortC(int[] arr, int low, int high) {
        if (low >= high) return;
        int p = partition(arr, low, high);
        quickSortC(arr, low, p-1);
        quickSortC(arr, p+1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = tmp;
        return i+1;
    }
}
