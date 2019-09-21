package com.solarexsoft.playingwithdatastructures.queues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/21.
 * Desc:
 */
public class SolarexLinkedQueueTest {

    @Test
    public void testLinkedQueu() {
        SolarexLinkedQueue<Integer> linkedQueue = new SolarexLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedQueue.enqueue(i);
            System.out.print(linkedQueue);
            if (i % 3 == 0) {
                linkedQueue.dequeue();
                System.out.print(linkedQueue);
            }
        }
    }

}