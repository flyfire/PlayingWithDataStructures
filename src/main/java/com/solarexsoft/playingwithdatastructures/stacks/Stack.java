package com.solarexsoft.playingwithdatastructures.stacks;

/**
 * Created by houruhou on 2019/3/4.
 * Desc:
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
