package com.solarexsoft.playingwithdatastructures.hashtable;

import com.solarexsoft.playingwithdatastructures.setmap.Map;

import java.util.TreeMap;

/**
 * Created by houruhou on 2019/10/3.
 * Desc:
 */

// 底层数组是TreeMap数组，要求元素具有可比较性
// 取模的素数的选择参考 https://planetmath.org/goodhashtableprimes
public class SolarexHashTable<K extends Comparable<K>, V> implements Map<K, V> {
    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
                                    49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
                                    12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    private static final int upperTolerance = 10;
    private static final int lowerTolerance = 2;
    private int capacityIndex = 0;

    private TreeMap<K, V>[] table;
    private int size;
    private int M;

    public SolarexHashTable() {
        this.M = capacity[capacityIndex];
        size = 0;
        table = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            table[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // 先变成正数再取模
    }

    @Override
    public void add(K key, V value) {
        TreeMap<K, V> map = table[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            if (size >= upperTolerance * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    @Override
    public boolean contains(K key) {
        return table[hash(key)].containsKey(key);
    }

    @Override
    public V get(K key) {
        return table[hash(key)].get(key);
    }

    @Override
    public void set(K key, V newValue) {
        TreeMap<K, V> map = table[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, newValue);
        } else {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
    }

    @Override
    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = table[hash(key)];
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size <= lowerTolerance * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> map = table[i];
            for (K k : map.keySet()) {
                newTable[hash(k)].put(k, map.get(k));
            }
        }
        this.table = newTable;
    }
}
