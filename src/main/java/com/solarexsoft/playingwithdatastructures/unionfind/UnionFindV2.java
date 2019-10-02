package com.solarexsoft.playingwithdatastructures.unionfind;

/**
 * Created by houruhou on 2019/10/2.
 * Desc:
 */
public class UnionFindV2 implements UnionFind {
    private int[] parent; //parent[i] 表示元素所指向的父节点

    public UnionFindV2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    @Override
    public int getSize() {
        return parent.length;
    }

    // 查找元素p所对应的集合编号
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of boundary");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
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

        parent[pRoot] = qRoot;
    }
}
