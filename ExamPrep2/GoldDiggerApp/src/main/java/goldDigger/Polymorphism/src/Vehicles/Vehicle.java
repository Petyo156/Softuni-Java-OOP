package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    void drive(double distance){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double neededFuel = this.fuelConsumption*distance;
        if(this.fuelQuantity>=neededFuel){
            this.fuelQuantity-=neededFuel;
            System.out.printf("%s travelled %s km\n",this.getClass().getSimpleName(),decimalFormat.format(distance));
            return;
        }
        System.out.printf("%s needs refueling\n",this.getClass().getSimpleName());
    }

    abstract void fuel(double fuel);

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
}
