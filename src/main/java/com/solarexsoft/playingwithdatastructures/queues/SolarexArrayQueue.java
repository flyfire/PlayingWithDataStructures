package com.solarexsoft.playingwithdatastructures.queues;

import com.solarexsoft.playingwithdatastructures.arrays.SolarexArray;

/**
 * Created by houruhou on 2019/3/4.
 * Desc:
 */
public class SolarexArrayQueue<E> implements Queue<E> {
    private SolarexArray<E> array;

    public SolarexArrayQueue(int capacity) {
        array = new SolarexArray<>(capacity);
    }

    public SolarexArrayQueue() {
        array = new SolarexArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
