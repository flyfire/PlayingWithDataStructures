package com.solarexsoft.playingwithdatastructures.segmenttree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/10/1.
 * Desc:
 */
public class SegmentTreeTest {
    @Test
    public void testSegmentTree() {
        Integer[] nums = {-2, 0, 3, -5, -2, -1};
        SegmentTree<Integer> tree = new SegmentTree<>(nums, (a, b) -> (a+b));
        System.out.println(tree);
        System.out.println(tree.query(0, 5));
        System.out.println(tree.query(0, 2));
        System.out.println(tree.query(3, 5));
    }
}