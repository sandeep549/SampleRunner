package com.example.java_lib;

/**
 * Simple Trie data structure to insert and find keys.
 */
public class Trie {
    private static final int SIZE = 25;
    private TrieNode root = new TrieNode();

    /**
     * Insert key into Trie.
     */
    public void insert(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); ++i) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    /**
     * Find key in Trie.
     */
    public boolean search(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); ++i) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }

    private static class TrieNode {
        private TrieNode[] children = new TrieNode[SIZE];
        private boolean isEndOfWord = false;
    }
}
