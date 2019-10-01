package com.solarexsoft.playingwithdatastructures.trie;

import java.util.HashMap;

/**
 * Created by houruhou on 2019/10/1.
 * Desc:
 */
public class Trie {
    static class TrieNode {
        public boolean isWord;
        public HashMap<Character, TrieNode> next;

        public TrieNode(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public TrieNode() {
            this(false);
        }
    }

    private TrieNode root;
    private int size;

    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    // 获得trie中存储的单词数量
    public int getSize() {
        return size;
    }

    // 向trie中添加一个新的单词word
    public void add(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // 查询word是否在trie中
    public boolean contains(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询是否在trie中有单词以prefix为前缀
    public boolean hasPrefix(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return true;
    }
}
