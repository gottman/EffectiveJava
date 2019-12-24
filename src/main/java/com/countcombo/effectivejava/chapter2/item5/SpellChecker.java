package com.countcombo.effectivejava.chapter2.item5;

import java.util.List;

public class SpellChecker {
    private final List<String> dictionary;

    public SpellChecker(List<String> dictionary){
        this.dictionary = dictionary;
    }
    public boolean isValid(String word){
        return dictionary.contains(word);
    }
}
