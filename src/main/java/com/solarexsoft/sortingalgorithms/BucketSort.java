package com.solarexsoft.sortingalgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houruhou on 2019/10/6.
 * Desc:
 */
public class BucketSort extends SortingAlgorithms {
    @Override
    void sort(int[] arr, int start, int end) {

    }

    // 对分布均匀的数字排序算法比较有效
    // 单个桶内排序使用插入排序，单个桶内元素尽量保持在5~10个左右
    public void bucketSort(int[] arr, int start, int end, int bucketsize) {
        int min = arr[start], max = arr[start];
        for (int i = start+1; i < end; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        int bucketCount = (end - start) / bucketsize;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = start; i < end; i++) {
            int idx = (int)((arr[i] - min)/(max - min + 1.0) * bucketCount);
            buckets.get(idx).add(arr[i]);
        }

        int idx = 0;
        for (List<Integer> bucket : buckets) {
            insertionSort(bucket);
            for (Integer integer : bucket) {
                arr[idx++] = integer;
            }
        }
    }

    private void insertionSort(List<Integer> list) {
        if (list == null || list.size() == 0) return;
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > cur) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, cur);
        }
    }
}
