package solid.products;

import solid.interfaces.Food;
import solid.interfaces.Product;

public class Chocolate implements Product, Food {

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private double grams;

    public Chocolate(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }


    @Override
    public double getCalories() {
        return (CALORIES_PER_100_GRAMS/100) * getGrams();
    }

    @Override
    public double amountOfFood() {
        return getGrams()/1000;
    }
}
