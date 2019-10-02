package com.solarexsoft.playingwithdatastructures.unionfind;

/**
 * Created by houruhou on 2019/10/2.
 * Desc:
 */
public class UnionFindV1 implements UnionFind {
    private int[] id;

    public UnionFindV1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }
    @Override
    public int getSize() {
        return id.length;
    }

    // 查找元素p所对应的集合编号
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of boundary");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pRoot) {
                id[i] = qRoot;
            }
        }
    }
}
