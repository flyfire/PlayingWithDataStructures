package com.solarexsoft.playingwithdatastructures.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by houruhou on 2020/1/9.
 * Desc:
 */
public class TreeNodeTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        t4.left = t8; t4.right = t9;
        t5.left = t10; t5.right = t11;
        t6.left = t12; t6.right = t13;
        t7.left = t14; t7.right = t15;
        preOrder(t1);
        System.out.println("\n------------------");
        inOrder(t1);
        System.out.println("\n------------------");
        postOrder(t1);
        System.out.println("\n------------------");
        levelOrder(t1);
        System.out.println("\n------------------");
        int[] pre = {1, 2,  4,	8,	9,	5,	10,	11,	3,	6,	12,	13,	7,	14,	15};
        int[] in = {8,	4,	9,	2,	10,	5,	11,	1,	12,	6,	13,	3,	14,	7,	15};
        TreeNode root = buildTree(pre, in);
        levelOrder(root);

    }

    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + "\t");
        inOrder(root.right);
    }

    static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + "\t");
    }

    static void levelOrder(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                System.out.print(node.val + "\t");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    static TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return buildTree(pre, 0, pre.length-1, 0, map);
    }

    static TreeNode buildTree(int[] pre, int preStart, int preEnd, int inStart, Map<Integer, Integer> inPos) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIndex = inPos.get(pre[preStart]);
        int leftLen = rootIndex - inStart;
        root.left = buildTree(pre, preStart + 1, preStart + leftLen, inStart, inPos);
        root.right = buildTree(pre, preStart+leftLen+1, preEnd, rootIndex + 1, inPos);
        return root;
    }
}
