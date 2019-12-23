package com.countcombo.effectivejava;

import com.countcombo.effectivejava.chaptertwo.itemone.FactoryMethodExample;
import com.countcombo.effectivejava.chaptertwo.itemtwo.NutritionFact;
import com.countcombo.effectivejava.chaptertwo.itemtwo.NutritionFactWithBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ChapterTwoTest {
    @Test
    public void itemOneTest() {
        FactoryMethodExample constructorExample = new FactoryMethodExample(true);
        assertEquals("Factory Method fromInt rather than constructor",
            constructorExample, FactoryMethodExample.fromInt(1));
        assertEquals("Factory Method fromString rather than constructor",
                constructorExample, FactoryMethodExample.fromString("TRUE"));
    }

    @Test
    public void itemTwoTest() {
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
}
