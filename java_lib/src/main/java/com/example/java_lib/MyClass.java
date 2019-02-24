package com.example.java_lib;

public class MyClass {
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

        Trie2 trie2 = new Trie2();
        trie2.insert("sandeep");
        trie2.insert("simar");
        trie2.insert("daksh");
        System.out.println("Find sandeep=" + trie2.find("sandeep"));
        trie2.printSuggestions("s");
    }
}