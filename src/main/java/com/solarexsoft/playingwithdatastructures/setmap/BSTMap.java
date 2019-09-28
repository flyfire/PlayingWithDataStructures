package com.solarexsoft.playingwithdatastructures.setmap;

/**
 * Created by houruhou on 2019/9/28.
 * Desc:
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    static class BSTNode<K, V> {
        public K key;
        public V value;
        public BSTNode<K, V> left,right;

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private BSTNode<K, V> root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private BSTNode<K, V> add(BSTNode<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new BSTNode<>(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private BSTNode<K, V> getNode(BSTNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        BSTNode<K, V> node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        BSTNode<K, V> node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = newValue;
    }

    private BSTNode<K, V> minimum(BSTNode<K, V> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private BSTNode<K, V> removeMin(BSTNode<K, V> node) {
        if (node.left == null) {
            BSTNode<K, V> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) {
        BSTNode<K, V> node = getNode(root, key);
        if (node != null) {

        }
        return null;
    }

    private BSTNode<K, V> remove(BSTNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                BSTNode<K, V> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                BSTNode<K, V> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            BSTNode<K, V> successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
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
