package com.solarexsoft.playingwithdatastructures.setmap;

/**
 * Created by houruhou on 2019/9/28.
 * Desc:
 */
public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
