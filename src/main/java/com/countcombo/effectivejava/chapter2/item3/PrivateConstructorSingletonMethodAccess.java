package com.countcombo.effectivejava.chapter2.item3;

import java.io.Serializable;

public class PrivateConstructorSingletonMethodAccess implements Serializable {
    private PrivateConstructorSingletonMethodAccess(){}
    private static final transient PrivateConstructorSingletonMethodAccess INSTANCE = new PrivateConstructorSingletonMethodAccess();
    public static final PrivateConstructorSingletonMethodAccess getInstance(){
        return INSTANCE;
    }
    private Object readResolve(){
        //readResolve preserves Singleton property while using Serializable
        return INSTANCE;
    }
}
