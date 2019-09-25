package com.solarexsoft.playingwithdatastructures.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by houruhou on 2019/9/24.
 * Desc:
 */
public class BinarySearchTree<E extends Comparable<E>> {
    static class Node<E> {
        public E e;
        public Node<E> left, right;

        public Node(E e) {
            this.e = e;
            left = right = null;
        }
    }

    private Node<E> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素e，递归算法
    //返回插入新节点后二分搜索树的根
    private Node<E> add(Node<E> node, E e) {
        if (node == null) {
            size++;
            return new Node<>(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e
    private boolean contains(Node<E> node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }

        return minimum(root).e;
    }

    private Node<E> minimum(Node<E> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is empty");
        }
        return maximum(root).e;
    }

    private Node<E> maximum(Node<E> node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node<E> removeMin(Node<E> node) {
        if (node.left == null) {
            Node<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node<E> removeMax(Node<E> node) {
        if (node.right == null) {
            Node<E> leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 删除掉以node为根的二分搜索树中值为e的节点，递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node<E> remove(Node<E> node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else {
            if (node.left == null) {
                Node<E> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node<E> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node<E> successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node<E> node, int i, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(i) + "null\n");
            return;
        }
        sb.append(generateDepthString(i) + node.e + "\n");
        generateBSTString(node.left, i + 1, sb);
        generateBSTString(node.right, i + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}
