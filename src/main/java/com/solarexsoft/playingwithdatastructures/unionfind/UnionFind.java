package com.solarexsoft.playingwithdatastructures.unionfind;

/**
 * Created by houruhou on 2019/10/2.
 * Desc:
 */
public interface UnionFind {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
