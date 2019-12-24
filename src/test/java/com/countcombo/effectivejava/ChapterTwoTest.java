package com.countcombo.effectivejava;

import com.countcombo.effectivejava.chapter2.item1.FactoryMethodExample;
import com.countcombo.effectivejava.chapter2.item2.NutritionFact;
import com.countcombo.effectivejava.chapter2.item2.NutritionFactWithBuilder;
import com.countcombo.effectivejava.chapter2.item3.EnumSingleton;
import com.countcombo.effectivejava.chapter2.item3.PrivateConstructorSingletonFieldAccess;
import com.countcombo.effectivejava.chapter2.item3.PrivateConstructorSingletonMethodAccess;
import com.countcombo.effectivejava.chapter2.item4.UtilityClass;
import com.countcombo.effectivejava.chapter2.item5.SpellChecker;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ChapterTwoTest {

    @Test
    public void item1Test() {
        FactoryMethodExample constructorExample = new FactoryMethodExample(true);
        assertEquals("Factory Method fromInt rather than constructor",
            constructorExample, FactoryMethodExample.fromInt(1));
        assertEquals("Factory Method fromString rather than constructor",
                constructorExample, FactoryMethodExample.fromString("TRUE"));
    }

    @Test
    public void item2Test() {
        assertEquals("Builder rather than constructor",
            new NutritionFact(1, 6, 150, 12.0, 6.0, 2.0),
            new NutritionFactWithBuilder
                    .Builder(1,6,150)
                    .carbohydrate(12.0)
                    .fat(6.0)
                    .protein(2.0)
                    .build()
        );
    }

    @Test
    public void item3Test(){
        assertSame("Singleton with Private constructor and field access",
            PrivateConstructorSingletonFieldAccess.INSTANCE,
            PrivateConstructorSingletonFieldAccess.INSTANCE
        );
        assertSame("Singleton with Private constructor and method access",
            PrivateConstructorSingletonMethodAccess.getInstance(),
            PrivateConstructorSingletonMethodAccess.getInstance()
        );
        assertSame("Singleton using single element Enum",
            EnumSingleton.INSTANCE,
            EnumSingleton.INSTANCE
        );
    }

    @Test(expected = InvocationTargetException.class)
    public void item4Test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //Accessing the private constructor that throws AssertionError via reflection causes an InvocationTargetException
        Constructor<UtilityClass> constructor = UtilityClass.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        UtilityClass su = constructor.newInstance();
    }

    @Test
    public void item5Test() {
        SpellChecker sc = new SpellChecker(Arrays.asList("a", "b", "c", "d"));
        assertEquals("Dependency Injection allows dictionary injection on creation", true, sc.isValid("a") );
        assertEquals("Dependency Injection allows dictionary injection on creation", false, sc.isValid("e") );
        sc = new SpellChecker(Arrays.asList("e", "f", "g", "h"));
        assertEquals("Dependency Injection allows dictionary injection on creation", false, sc.isValid("a") );
        assertEquals("Dependency Injection allows dictionary injection on creation", true, sc.isValid("e") );
    }

    @Test
    public void item6Test() {
        
    }
}
