package com.solarexsoft.playingwithdatastructures.setmap;

import com.solarexsoft.playingwithdatastructures.redblack.RedBlackTree;
import com.solarexsoft.playingwithdatastructures.utils.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

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
 */
    }
}