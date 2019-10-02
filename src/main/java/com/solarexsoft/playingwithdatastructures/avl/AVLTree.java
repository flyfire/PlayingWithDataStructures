package com.solarexsoft.playingwithdatastructures.avl;

import java.util.ArrayList;

/**
 * Created by houruhou on 2019/10/2.
 * Desc:
 */
public class AVLTree<K extends Comparable<K>, V> {
    public static class AVLNode<K, V> {
        public K key;
        public V value;
        public AVLNode<K, V> left, right;
        public int height;

        public AVLNode(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private AVLNode<K,V> root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 判断该二叉树是否是一颗二分搜索树
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i-1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(AVLNode<K, V> node, ArrayList<K> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);
    }

    // 判断该二叉树是否是一颗平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    // 判断以node为根的二叉树是否是一颗平衡二叉树
    private boolean isBalanced(AVLNode<K, V> node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    // 获得节点node的高度
    private int getHeight(AVLNode<K,V> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // 获得节点node的平衡因子
    private int getBalanceFactor(AVLNode<K,V> node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private AVLNode<K, V> rightRotate(AVLNode<K,V> y) {
        AVLNode<K, V> x = y.left;
        AVLNode<K, V> T3 = x.right;

        // 右旋
        x.right = y;
        y.left = T3;

        // 更新高度
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private AVLNode<K,V> leftRotate(AVLNode<K, V> y) {
        AVLNode<K, V> x = y.right;
        AVLNode<K, V> T2 = x.left;

        // 左旋
        x.left = y;
        y.right = T2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素(key,value)
    // 返回插入新节点后二分搜索树的根
    private AVLNode<K, V> add(AVLNode<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new AVLNode<>(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left); // 转换为LL情况
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right); // 转换为RR情况
            return leftRotate(node);
        }

        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private AVLNode<K, V> getNode(AVLNode<K, V> node, K key) {
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
        AVLNode<K, V> node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        AVLNode<K, V> node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn'g exist");
        }

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private AVLNode<K, V> minimum(AVLNode<K, V> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key) {
        AVLNode<K, V> node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private AVLNode<K, V> remove(AVLNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        AVLNode<K, V> retNode;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            // 待删除节点左子树为空
            if (node.left == null) {
                AVLNode<K, V> rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                AVLNode<K, V> leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                AVLNode<K, V> successor = minimum(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                retNode = successor;
            }
        }

        if (retNode == null) {
            return null;
        }

        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        int balanceFactor = getBalanceFactor(retNode);

        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }
}
