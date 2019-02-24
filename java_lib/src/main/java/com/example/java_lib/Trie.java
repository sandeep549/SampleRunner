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

    /**
     * This function will print all the words in the dictionary
     * that have given string as prefix.
     * 1. Check if prefix itself not present.
     * 2. Check if prefix end itself as word.
     * 3. Print all words that has this prefix.
     */
    public void printSuggestions(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null)
                return; // prefix not present
            node = node.children[index];
        }
        if (node != null && node.isEndOfWord) {
            System.out.println(prefix);
            return; // prefix itself is word
        }
        printSuggestions(prefix, node);
    }

    private void printSuggestions(String prefix, TrieNode node) {
        if (node == null) {
            return;
        }
        if (node.isEndOfWord)
            System.out.println(prefix);
        for (int i = 0; i < node.children.length; i++) {
            char ch = (char) ('a' + i);
            printSuggestions(prefix + ch, node.children[i]);
        }
    }

    /**
     * Node in Trie data structure.
     */
    private static class TrieNode {
        private TrieNode[] children = new TrieNode[SIZE];
        private boolean isEndOfWord = false;
    }
}
