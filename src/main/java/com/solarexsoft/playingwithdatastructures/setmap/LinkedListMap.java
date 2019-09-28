package com.solarexsoft.playingwithdatastructures.setmap;

import java.util.prefs.NodeChangeEvent;

/**
 * Created by houruhou on 2019/9/28.
 * Desc:
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    static class LinkMapNode<K, V> {
        public K key;
        public V value;
        public LinkMapNode<K, V> next;

        public LinkMapNode(K key, V value, LinkMapNode<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public LinkMapNode(K key, V value) {
            this(key, value, null);
        }

        public LinkMapNode() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            if (key != null && value != null) {
                return key.toString() + " : " + value.toString();
            }
            return null;
        }
    }

    private LinkMapNode<K, V> dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new LinkMapNode<>();
        size = 0;
    }

    private LinkMapNode<K, V> getNode(K key) {
        LinkMapNode<K, V> cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        LinkMapNode<K, V> node = getNode(key);
        if (node == null) {
            dummyHead.next = new LinkMapNode<>(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        LinkMapNode<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        LinkMapNode<K,V> node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = newValue;
    }

    @Override
    public V remove(K key) {
        LinkMapNode<K, V> prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            LinkMapNode<K, V> delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
