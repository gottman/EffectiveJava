package com.countcombo.effectivejava.chapter2.item1;

import java.util.Objects;

public class FactoryMethodExample{
    private boolean attribute;
    public FactoryMethodExample(boolean b){
        attribute = b;
    }
    public static FactoryMethodExample fromString(String s) {
        return new FactoryMethodExample(s.toLowerCase().equals("true"));
    }
    public static FactoryMethodExample fromInt(int i){
        return new FactoryMethodExample(i==1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FactoryMethodExample)) return false;
        FactoryMethodExample that = (FactoryMethodExample) o;
        return attribute == that.attribute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attribute);
    }
}
