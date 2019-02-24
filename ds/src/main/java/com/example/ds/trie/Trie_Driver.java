package com.example.ds.trie;

public class Trie_Driver {
    public static void main(String[] args){
        System.out.println("===============");
        Trie trie = new Trie();
        trie.insert("sandeep");
        trie.insert("simar");
        trie.insert("daksh");
        trie.insert("anaya");
        trie.insert("howareyou");
        trie.insert("howdoyoudo");
        System.out.println("Find simar=" + trie.search("simar"));
        System.out.println("Find anya=" + trie.search("anaya"));

        trie.printSuggestions("how");
    }
}