package _4_PizzaCalories;

import java.util.Map;

public class Dough {
    private static final int BASE_CALORIES = 2;
    private static final Map<String, Double> DOUGH_TYPE = Map.of(
            "White",1.5,
            "Wholegrain",1.0
    );
    private static final Map<String, Double> BAKING_TECHNIQUES = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0
    );

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public void setFlourType(String flourType) {
        if(DOUGH_TYPE.containsKey(flourType)) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setBakingTechnique(String bakingTechnique) {
        if(BAKING_TECHNIQUES.containsKey(bakingTechnique)) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setWeight(double weight) {
        if(weight>0 && weight<=200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("_4_PizzaCalories.Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories(){
        return BASE_CALORIES * this.weight *
                DOUGH_TYPE.get(this.flourType) *
                BAKING_TECHNIQUES.get(this.bakingTechnique);
    }
}
