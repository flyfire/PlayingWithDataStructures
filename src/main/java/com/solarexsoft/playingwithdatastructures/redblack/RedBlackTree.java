package com.solarexsoft.playingwithdatastructures.redblack;


import com.solarexsoft.playingwithdatastructures.setmap.Map;

/**
 * Created by houruhou on 2019/10/3.
 * Desc:
 */
public class RedBlackTree<K extends Comparable<K>, V> implements Map<K, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    static class RedBlackNode<K, V> {
        public K key;
        public V value;
        public RedBlackNode<K, V> left, right;
        public boolean color;

        public RedBlackNode(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private RedBlackNode<K, V> root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 判断节点node的颜色
    private boolean isRed(RedBlackNode<K, V> node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private RedBlackNode<K,V> leftRotate(RedBlackNode<K, V> node) {
        RedBlackNode<K, V> x = node.right;

        // 左旋
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private RedBlackNode<K, V> rightRotate(RedBlackNode<K, V> node) {
        RedBlackNode<K, V> x = node.left;

        // 右旋
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    // 颜色翻转
    private void flipColors(RedBlackNode<K, V> node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    // 向红黑树中添加新的元素(key, value)
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK; // 最终根节点的颜色是黑色
    }

    // 向以node为根的红黑树中插入元素(key,value)
    // 返回插入新节点后红黑树的根
    private RedBlackNode<K, V> add(RedBlackNode<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new RedBlackNode<>(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 进行调整
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private RedBlackNode<K, V> getNode(RedBlackNode<K, V> node, K key) {
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

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        RedBlackNode<K, V> node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        RedBlackNode<K, V> node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在节点
    private RedBlackNode<K, V> minimum(RedBlackNode<K, V> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private RedBlackNode<K, V> removeMin(RedBlackNode<K, V> node) {
        if (node.left == null) {
            RedBlackNode<K, V> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key) {
        RedBlackNode<K, V> node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private RedBlackNode<K, V> remove(RedBlackNode<K, V> node, K key) {
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

            // todo 调整树达到黑平衡
            // 待删除节点左子树为空
            if (node.left == null) {
                RedBlackNode<K, V> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                RedBlackNode<K, V> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            RedBlackNode<K, V> successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }
}
