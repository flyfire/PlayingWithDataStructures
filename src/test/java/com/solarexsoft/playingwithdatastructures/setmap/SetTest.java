package com.solarexsoft.playingwithdatastructures.setmap;

import com.solarexsoft.playingwithdatastructures.utils.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/28.
 * Desc:
 */
public class SetTest {

    public double testSet(Set<String> set, String path) {
        long start = System.nanoTime();
//        String path = Set.class.getClassLoader().getResource(filename).getPath();
        System.out.println("file path = " + path);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(path, words)) {
            System.out.println("words total size = " + words.size());
            for (String word : words) {
                set.add(word);
            }
            System.out.println("words distinct size = " + set.getSize());
        }
        long end = System.nanoTime();
        return (end - start)/1000000000.0;
    }

    @Test
    public void testSetTime() {
        String tale = "a-tale-of-two-cities.txt";
        String pride = "pride-and-prejudice.txt";
        String talePath = Set.class.getClassLoader().getResource(tale).getPath();
        System.out.println("tale path = " + talePath);
        String pridePath = Set.class.getClassLoader().getResource(pride).getPath();
        System.out.println("pride path = " + pridePath);

        System.out.println("test linkedlist set");
        double linkTaleTime = testSet(new LinkedListSet<>(), talePath);
        double linkPrideTime = testSet(new LinkedListSet<>(), pridePath);
        System.out.println("link tale time = " + linkTaleTime + " s");
        System.out.println("link pride time = " + linkPrideTime + " s");
        System.out.println("test bstset");
        double bstTaleTime = testSet(new BSTSet<>(), talePath);
        double bstPrideTime = testSet(new BSTSet<>(), pridePath);
        System.out.println("bst tale time = " + bstTaleTime + " s");
        System.out.println("bst pride time = " + bstPrideTime + " s");
        System.out.println("test avlset");
        double avlTalTime = testSet(new AVLSet<>(), talePath);
        double avlPrideTime = testSet(new AVLSet<>(), pridePath);
        System.out.println("avl tale time = " + avlTalTime + " s");
        System.out.println("avl pride time = " + avlPrideTime + " s");
    }

}