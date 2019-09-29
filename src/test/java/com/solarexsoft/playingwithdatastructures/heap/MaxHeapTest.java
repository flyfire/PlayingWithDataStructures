package com.solarexsoft.playingwithdatastructures.heap;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/29.
 * Desc:
 */
public class MaxHeapTest {

    private double testHeap(Integer[] data, boolean isHeapify) {
        long start = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(data);
        } else {
            maxHeap = new MaxHeap<>();
            for (Integer datum : data) {
                maxHeap.add(datum);
            }
        }
        int[] arr = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i< arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("build heap error");
            }
        }
        System.out.println("test heap complete isheapify = " + isHeapify);
        long end = System.nanoTime();
        return (end - start)/1000000000.0;
    }

    @Test
    public void test() {
        int opCount = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[opCount];
        for (int i = 0; i < opCount; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double without = testHeap(testData, false);
        System.out.println("without heapify cost " + without + " s");

        double with = testHeap(testData, true);
        System.out.println("with heapify cost " + with + " s");
    }
}