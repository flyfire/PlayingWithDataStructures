package com.solarexsoft.playingwithdatastructures.setmap;

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
    }
}