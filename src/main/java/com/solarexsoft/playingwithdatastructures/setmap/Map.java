package com.solarexsoft.playingwithdatastructures.setmap;

/**
 * Created by houruhou on 2019/9/28.
 * Desc:
 */
public interface Map<K, V> {
    void add(K key, V value);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    V remove(K key);
    int getSize();
    boolean isEmpty();
}
