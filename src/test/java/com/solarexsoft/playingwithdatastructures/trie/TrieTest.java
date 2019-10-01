package com.solarexsoft.playingwithdatastructures.trie;

import com.solarexsoft.playingwithdatastructures.setmap.BSTSet;
import com.solarexsoft.playingwithdatastructures.setmap.Set;
import com.solarexsoft.playingwithdatastructures.utils.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/10/1.
 * Desc:
 */
public class TrieTest {
    @Test
    public void testTrie() {
        String tale = "a-tale-of-two-cities.txt";
        String pride = "pride-and-prejudice.txt";
        String talePath = Set.class.getClassLoader().getResource(tale).getPath();
        System.out.println("tale path = " + talePath);
        String pridePath = Set.class.getClassLoader().getResource(pride).getPath();
        System.out.println("pride path = " + pridePath);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(talePath, words) && FileOperation.readFile(pridePath, words)) {
            long bstStart = System.nanoTime();
            BSTSet<String> bstSet = new BSTSet<>();
            for (String word : words) {
                bstSet.add(word);
            }
            for (String word : words) {
                bstSet.contains(word);
            }
            long bstEnd = System.nanoTime();

            double bstTime = (bstEnd - bstStart)/1000000000.0;

            System.out.println("total different words " + bstSet.getSize());
            System.out.println("BSTSet time = " + bstTime + " s");

            long trieStart = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }
            for (String word : words) {
                trie.contains(word);
            }
            long trieEnd = System.nanoTime();

            double trieTime = (trieEnd - trieStart)/1000000000.0;

            System.out.println("total different words " + trie.getSize());
            System.out.println("trie time = " + trieTime + " s");
        }
    }
}