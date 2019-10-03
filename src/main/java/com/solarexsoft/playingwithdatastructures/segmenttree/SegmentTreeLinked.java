package com.solarexsoft.playingwithdatastructures.segmenttree;

/**
 * Created by houruhou on 2019/10/3.
 * Desc:
 */
public class SegmentTreeLinked<E> {

    static class SegmentTreeNode<E> {
        public int start,end;
        public SegmentTreeNode<E> left,right;
        public E merged;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.merged = null;
        }
    }

    SegmentTreeNode<E> root = null;
    Merger<E> merger;

    public SegmentTreeLinked(E[] nums, Merger<E> merger) {
        root = buildTree(nums, 0, nums.length - 1);
        this.merger = merger;
    }

    private SegmentTreeNode<E> buildTree(E[] nums,int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode<E> ret = new SegmentTreeNode<>(start, end);
            if (start == end) {
                ret.merged = merger.index2Element(ret.start);
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid+1, end);
                ret.merged = merger.merge(ret.left.merged, ret.right.merged);
            }
            return ret;
        }
    }

    public void update(int i, E val) {
        update(root, i, val);
    }

    public void update(SegmentTreeNode<E> root,int pos, E val) {
        if (root.start == root.end) {
            root.merged = val;
        } else {
            int mid = root.start + (root.end - root.start)/2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.merged = merger.merge(root.left.merged, root.right.merged);
        }
    }

    public E query(int i, int j) {
        return query(root, i, j);
    }

    public E query(SegmentTreeNode<E> root,int start, int end) {
        if (root.end == end && root.start == root.start) {
            return root.merged;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return query(root.left, start, end);
            } else if (start >= mid+1) {
                return query(root.right, start, end);
            } else {
                E leftResult = query(root.left, start, mid);
                E rightResult = query(root.right, mid+1, end);
                return merger.merge(leftResult, rightResult);
            }
        }
    }
}
