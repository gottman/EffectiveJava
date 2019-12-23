package com.countcombo.effectivejava.chaptertwo.itemtwo;

import java.util.Objects;

public class NutritionFact {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final double carbohydrate;
    private final double fat;
    private final double protein;

    public NutritionFact(int servingSize, int servings, int calories,
            double carbohydrate, double fat, double protein){
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.protein = protein;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NutritionFact)) return false;
        NutritionFact that = (NutritionFact) o;
        return  that.servingSize == servingSize &&
                that.servings == servings &&
                that.calories == calories &&
                Double.compare(that.carbohydrate, carbohydrate) == 0 &&
                Double.compare(that.fat, fat) == 0 &&
                Double.compare(that.protein, protein) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(servingSize, servings, calories, carbohydrate, fat, protein);
    }
}
