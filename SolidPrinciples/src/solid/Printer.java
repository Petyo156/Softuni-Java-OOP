package solid;

import solid.interfaces.Product;

import java.util.List;

public class Printer {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    CalorieCalculator calorieCalculator;

    public Printer(CalorieCalculator calorieCalculator) {
        this.calorieCalculator = calorieCalculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", this.calorieCalculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", this.calorieCalculator.average(products));
    }
}
