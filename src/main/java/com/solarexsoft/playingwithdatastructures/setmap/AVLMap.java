package com.solarexsoft.playingwithdatastructures.setmap;

import com.solarexsoft.playingwithdatastructures.avl.AVLTree;

/**
 * Created by houruhou on 2019/10/2.
 * Desc:
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> avlTree;

    public AVLMap() {
        avlTree = new AVLTree<>();
    }
    @Override
    public void add(K key, V value) {
        avlTree.add(key, value);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avlTree.set(key, newValue);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
