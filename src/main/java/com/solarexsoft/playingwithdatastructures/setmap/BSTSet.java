package com.solarexsoft.playingwithdatastructures.setmap;

import com.solarexsoft.playingwithdatastructures.bst.BinarySearchTree;

/**
 * Created by houruhou on 2019/9/28.
 * Desc:
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    public BSTSet() {
        bst = new BinarySearchTree<>();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
