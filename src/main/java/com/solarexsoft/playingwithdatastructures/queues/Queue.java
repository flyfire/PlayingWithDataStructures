package com.solarexsoft.playingwithdatastructures.queues;

/**
 * Created by houruhou on 2019/3/4.
 * Desc:
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
