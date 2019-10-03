package com.solarexsoft.playingwithdatastructures.segmenttree;

/**
 * Created by houruhou on 2019/10/1.
 * Desc:
 */
public interface Merger<E> {
    E merge(E a, E b);
    E index2Element(int start);
}
