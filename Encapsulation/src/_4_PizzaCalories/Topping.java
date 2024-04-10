package _4_PizzaCalories;

import java.util.Map;

public class Topping {
    private static final int BASE_CALORIES = 2;
    private static final Map<String, Double> MODIFIERS = Map.of(
            "Meat",1.2,
            "Veggies",0.8,
            "Cheese", 1.1,
            "Sauce", 0.9
    );

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(MODIFIERS.containsKey(toppingType)){
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
    }

    private void setWeight(double weight) {
        if(weight>0 && weight<=50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",this.toppingType));
        }
    }

    public double calculateCalories(){

        return BASE_CALORIES * this.weight * MODIFIERS.get(this.toppingType);
    }
}
