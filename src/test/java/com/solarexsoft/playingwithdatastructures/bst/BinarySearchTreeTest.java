package com.solarexsoft.playingwithdatastructures.bst;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/24.
 * Desc:
 */
public class BinarySearchTreeTest {
    @Test
    public void testBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int opCount = 10000;
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            bst.add(random.nextInt(Integer.MAX_VALUE));
        }
        ArrayList<Integer> list = new ArrayList<>();
        int size = bst.getSize();
        for (int i = 0; i < size; i++) {
            list.add(bst.removeMin());
        }
        for (int i = 1; i < size; i++) {
            if (list.get(i - 1) > list.get(i)) {
                throw new IllegalArgumentException("bst error");
            }
        }
        System.out.println("bst complete");
    }
}