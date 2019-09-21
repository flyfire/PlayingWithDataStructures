package com.solarexsoft.playingwithdatastructures.queues;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/3/4.
 * Desc:
 */
public class SolarexLoopQueueTest {

    private double testQueue(Queue<Integer> queue, int opCount) {
        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
    @Test
    public void testArrayQueueLoopQueue() {
        int opCount = 100000;
        SolarexArrayQueue<Integer> arrayQueue = new SolarexArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("array queue cost " + time1 + " s");

        SolarexLoopQueue<Integer> loopQueue = new SolarexLoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("loop queue cost " + time2 + " s");
    }
}