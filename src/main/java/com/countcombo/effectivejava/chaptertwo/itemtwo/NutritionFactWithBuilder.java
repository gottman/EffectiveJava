package com.countcombo.effectivejava.chaptertwo.itemtwo;

public class NutritionFactWithBuilder extends NutritionFact {

    public static class Builder{

        private final int servingSize;
        private final int servings;
        private final int calories;
        private double carbohydrate = 0;
        private double fat = 0;
        private double protein = 0;

        public Builder(int servingSize, int servings, int calories){
            this.servingSize = servingSize;
            this.servings = servings;
            this.calories = calories;
        }

        public Builder carbohydrate(double val){
            carbohydrate = val;
            return this;
        }

        public Builder fat(double val){
            fat = val;
            return this;
        }

        public Builder protein (double val){
            protein = val;
            return this;
        }

        public NutritionFactWithBuilder build(){
            return new NutritionFactWithBuilder(this);
        }
    }

    public NutritionFactWithBuilder(Builder builder){
        super(
            builder.servingSize,
            builder.servings,
            builder.calories,
            builder.carbohydrate,
            builder.fat,
            builder.protein
        );
    }


}
