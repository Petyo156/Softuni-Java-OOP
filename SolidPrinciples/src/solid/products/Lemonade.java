package solid.products;

import solid.interfaces.Drink;
import solid.interfaces.Product;

public class Lemonade implements Product, Drink {

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        return CALORIES_PER_100_GRAMS / 100 * (DENSITY * getMilliliters());
    }

    @Override
    public double amountOfDrink() {
        return getMilliliters()/1000;
    }
}
