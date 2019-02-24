package com.example.java_lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Map based Trie implementation
 */
public class Trie2 {

    Node root;

    public Trie2() {
        root = new Node('0');
    }

    /**
     * Insert word into Trie.
     */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i)))
                node.children.put(word.charAt(i), new Node(word.charAt(i)));
            node = node.children.get(word.charAt(i));
        }
        node.end = true;
    }

    /**
     * Find word into Trie
     */
    public boolean find(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children.containsKey(word.charAt(i))) node = node.children.get(word.charAt(i));
            else return false;
        }
        return node != null && node.end;
    }

    /**
     * This function will print all the words in the dictionary
     * that have given string as prefix.
     * 1. Check if prefix itself not present.
     * 2. Check if prefix end itself as word.
     * 3. Print all words that has this prefix.
     */
    public void printSuggestions(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children.containsKey(prefix.charAt(i)))
                node = node.children.get(prefix.charAt(i));
            else return; // prefix not present
        }
        if (node != null && node.end) {
            System.out.println(prefix);
            return; // prefix itself is word
        }
        printSuggestions(prefix, node);
    }

    private void printSuggestions(String prefix, Node node) {
        if (node == null) {
            return;
        }
        if (node.end)
            System.out.println(prefix);
        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            printSuggestions(prefix + entry.getKey(), entry.getValue());
        }
    }

    private static class Node {
        char c;
        boolean end;
        Map<Character, Node> children = new HashMap<>();

        Node(char c) {
            this.c = c;
        }
    }
}
