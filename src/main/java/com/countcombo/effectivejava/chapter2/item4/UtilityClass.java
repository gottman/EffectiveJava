package com.countcombo.effectivejava.chapter2.item4;

public class UtilityClass {
    //private constructor to enforce noninstantiability
    private UtilityClass(){
        throw new AssertionError();
    }
}
