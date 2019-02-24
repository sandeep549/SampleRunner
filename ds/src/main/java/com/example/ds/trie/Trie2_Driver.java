package com.example.ds.trie;

public class Trie2_Driver {
    public static void main(String[] args) {
        Trie2 trie2 = new Trie2();
        trie2.insert("sandeep");
        trie2.insert("simar");
        trie2.insert("daksh");
        System.out.println("Find sandeep=" + trie2.find("sandeep"));

        trie2.printSuggestions("s");

        trie2.insert("how are you ?");
        trie2.insert("how do you do ?");
        trie2.printSuggestions("how");
    }
}