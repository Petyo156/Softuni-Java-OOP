package solid;

import solid.interfaces.Product;
import solid.products.Chocolate;
import solid.products.Coke;
import solid.products.Lemonade;

import java.util.List;

public class CalorieCalculator {

    public double sum(List<Product> products) {
        double sum = 0;
        for (Product p : products) {
            sum += p.getCalories();
        }
        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
