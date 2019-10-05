package com.solarexsoft.sortingalgorithms;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/10/5.
 * Desc:
 */
public class SortingAlgorithmsTest {
    private double testAlgorithms(SortingAlgorithms algorithms, int[] arr) {
        long start = System.nanoTime();
        algorithms.sort(arr, 0, arr.length);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]){
                throw new RuntimeException("sort error");
            }
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
    @Test
    public void testSort() {
        int opCount = 100000;
        int[] arr = new int[opCount];
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println("test bubble sort");
        double bubbleSortTime = testAlgorithms(new BubbleSort(), arr);
        System.out.println("bubble srot cost " + bubbleSortTime);
    }
}