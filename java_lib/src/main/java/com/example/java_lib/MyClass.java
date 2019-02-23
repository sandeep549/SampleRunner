package com.example.java_lib;

public class MyClass {
    public static void main(String[] args){
        System.out.println("===============");
        Trie trie = new Trie();
        trie.insert("sandeep");
        trie.insert("simar");
        trie.insert("daksh");
        trie.insert("anaya");
        System.out.println("Find simar=" + trie.search("simar"));
        System.out.println("Find anya=" + trie.search("anaya"));
    }
}