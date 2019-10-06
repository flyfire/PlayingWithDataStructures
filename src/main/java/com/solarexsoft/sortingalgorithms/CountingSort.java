package com.solarexsoft.sortingalgorithms;

/**
 * Created by houruhou on 2019/10/6.
 * Desc:
 */
public class CountingSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {
        sortLeft2Right(arr, start, end);
    }

    // indexes 最后存储的是排序后，相同数字在结果数组的开始位置，相同数字会依次向后填充
    // Time: O(n+k), Space: O(n+k)
    public void sortLeft2Right(int[] arr, int start, int end) {
        int max = arr[start], min = arr[start];
        for (int i = start + 1; i < end; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }

        int k = max - min;
        int[] indexes = new int[k+1];
        for (int i = start; i < end; i++) {
            ++indexes[arr[i] - min]; // 统计每个数字出现的次数
        }

        int positionStart = 0;
        for (int i = 0; i <= k; i++) {
            int count = indexes[i];
            indexes[i] = positionStart;
            positionStart += count;
        }

        int[] tmp = new int[end - start];
        for (int i = start; i < end; i++) {
            int idx = indexes[arr[i] - min];
            tmp[idx] = arr[i];
            ++indexes[arr[i] - min];
        }

        System.arraycopy(tmp, 0, arr, start, end - start);
    }

    // indexes 最后存储的是排序后，相同数字在结果数组中的结束位置，相同数字会依次向前填充
    // Time: O(n+k) Space: O(n+k)
    public void sortRight2Left(int arr[], int start, int end) {
        int max = arr[start], min = arr[start];
        for (int i = start + 1; i < end; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }

        int k = max - min;
        int[] indexes = new int[k+1];
        for (int i = start; i < end; i++) {
            ++indexes[arr[i] - min]; // 统计每个数字出现的次数
        }

        --indexes[0];
        for (int i = 1; i <= k; i++) {
            indexes[i] = indexes[i] + indexes[i-1];
        }

        int[] tmp = new int[end - start];
        for (int i = end - 1; i >= start; i--) {
            int idx = indexes[arr[i] - min];
            tmp[idx] = arr[i];
            --indexes[arr[i] - min];
        }

        System.arraycopy(tmp, 0, arr, 0, end - start);
    }

}
