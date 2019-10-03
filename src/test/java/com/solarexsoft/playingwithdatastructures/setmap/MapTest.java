package com.solarexsoft.playingwithdatastructures.setmap;

import com.solarexsoft.playingwithdatastructures.hashtable.SolarexHashTable;
import com.solarexsoft.playingwithdatastructures.redblack.RedBlackTree;
import com.solarexsoft.playingwithdatastructures.utils.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/28.
 * Desc:
 */
public class MapTest {
    private double testMap(Map<String, Integer> map, String path) {
        System.out.println(path);
        long start = System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(path, words)) {
            System.out.println("words total size = " + words.size());
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("map size = " + map.getSize());
            System.out.println("frequency of pride = " + map.get("pride"));
            System.out.println("frequency of prejudice = " + map.get("prejudice"));
        }
        long end = System.nanoTime();
        return (end - start)/1000000000.0;
    }

    @Test
    public void testMap() {
        String pride = "pride-and-prejudice.txt";
        String pridePath = Set.class.getClassLoader().getResource(pride).getPath();
        System.out.println("pride path = " + pridePath);

        double linkMapTime = testMap(new LinkedListMap<>(), pridePath);
        System.out.println("link map time = " + linkMapTime + " s");
        double bstMapTime = testMap(new BSTMap<>(), pridePath);
        System.out.println("bst map time = " + bstMapTime + " s");
        double avlMapTime = testMap(new AVLMap<>(), pridePath);
        System.out.println("avl map time = " + avlMapTime + " s");
        double redblackTreeTime = testMap(new RedBlackTree<>(), pridePath);
        System.out.println("red black tree time = " + redblackTreeTime + " s");
        double hashTableTime = testMap(new SolarexHashTable<>(), pridePath);
        System.out.println("hash table time = " + hashTableTime + " s");
/*
pride path = /Users/houruhou/icarbonx-android/learning/1DataStructureAndAlgorithms/PlayingWithDataStructures/out/production/resources/pride-and-prejudice.txt
/Users/houruhou/icarbonx-android/learning/1DataStructureAndAlgorithms/PlayingWithDataStructures/out/production/resources/pride-and-prejudice.txt
words total size = 125901
map size = 6530
frequency of pride = 53
frequency of prejudice = 11
link map time = 13.033911656 s
/Users/houruhou/icarbonx-android/learning/1DataStructureAndAlgorithms/PlayingWithDataStructures/out/production/resources/pride-and-prejudice.txt
words total size = 125901
map size = 6530
frequency of pride = 53
frequency of prejudice = 11
bst map time = 0.102633211 s
/Users/houruhou/icarbonx-android/learning/1DataStructureAndAlgorithms/PlayingWithDataStructures/out/production/resources/pride-and-prejudice.txt
words total size = 125901
map size = 6530
frequency of pride = 53
frequency of prejudice = 11
avl map time = 0.113605382 s
/Users/houruhou/icarbonx-android/learning/1DataStructureAndAlgorithms/PlayingWithDataStructures/out/production/resources/pride-and-prejudice.txt
words total size = 125901
map size = 6530
frequency of pride = 53
frequency of prejudice = 11
red black tree time = 0.076720912 s
/Users/houruhou/icarbonx-android/learning/1DataStructureAndAlgorithms/PlayingWithDataStructures/out/production/resources/pride-and-prejudice.txt
words total size = 125901
map size = 6530
frequency of pride = 53
frequency of prejudice = 11
hash table time = 0.057215081 s
 */
    }

    private double testAdd(Map<Integer, Integer> map, List<Integer> list) {
        long start = System.nanoTime();
        for (Integer integer : list) {
            map.add(integer, null);
        }
        long end = System.nanoTime();
        return (end - start)/1000000000.0;
    }
    @Test
    public void testMapAdd1() {
        Random random = new Random();
        int opCount = 20000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < opCount; i++) {
            list.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println("test bst");
        double bsttime = testAdd(new BSTMap<>(), list);
        System.out.println("bst cost time " + bsttime + " s");
        System.out.println("test avl");
        double avltime = testAdd(new AVLMap<>(), list);
        System.out.println("avl cost time " + avltime + " s");
        System.out.println("test redblack tree");
        double rbTime = testAdd(new RedBlackTree<>(), list);
        System.out.println("red black tree cost " + rbTime + " s");
/*
test bst
bst cost time 43.48906742 s
test avl
avl cost time 41.543432488 s
test redblack tree
red black tree cost 44.366516662 s
*/
    }

    @Test
    public void testMapAdd2() {
        int opCount = 20000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < opCount; i++) {
            list.add(i);
        }
        /*
        System.out.println("test bst");
        double bsttime = testAdd(new BSTMap<>(), list);
        System.out.println("bst cost time " + bsttime + " s");
        // stackoverflowerror
        */
        System.out.println("test avl");
        double avltime = testAdd(new AVLMap<>(), list);
        System.out.println("avl cost time " + avltime + " s");
        System.out.println("test redblack tree");
        double rbTime = testAdd(new RedBlackTree<>(), list);
        System.out.println("red black tree cost " + rbTime + " s");
/*
test avl
avl cost time 11.204869597 s
test redblack tree
red black tree cost 11.096205332 s
 */

    }
}