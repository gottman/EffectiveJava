package com.countcombo.effectivejava.chapter2.item3;

public class PrivateConstructorSingletonFieldAccess {
    public static final PrivateConstructorSingletonFieldAccess INSTANCE = new PrivateConstructorSingletonFieldAccess();
    private PrivateConstructorSingletonFieldAccess(){}
}
