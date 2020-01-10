package com.solarexsoft.playingwithdatastructures.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by houruhou on 2020/1/10.
 * Desc:
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            if (queue.size() < 3) {
                queue.offer(num);
            } else {
                int heapTop = queue.peek();
                if (heapTop > num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        System.out.println(queue);
    }
}
