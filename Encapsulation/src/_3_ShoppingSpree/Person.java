package _3_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if(null == name || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if(this.money < product.getCost()){
            throw new IllegalArgumentException
                    (String.format("%s can't afford %s",this.getName(),product.getName()));
        }
        System.out.printf("%s bought %s\n",this.getName(),product.getName());
        this.products.add(product);
        this.money-=product.getCost();
    }

    public String getName() {
        return name;
    }
}
