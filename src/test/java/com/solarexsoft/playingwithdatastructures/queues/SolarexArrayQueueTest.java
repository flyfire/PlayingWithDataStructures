package com.solarexsoft.playingwithdatastructures.queues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/3/4.
 * Desc:
 */
public class SolarexArrayQueueTest {
    @Test
    public void testArrayQueue() {
        SolarexArrayQueue<Integer> queue = new SolarexArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}