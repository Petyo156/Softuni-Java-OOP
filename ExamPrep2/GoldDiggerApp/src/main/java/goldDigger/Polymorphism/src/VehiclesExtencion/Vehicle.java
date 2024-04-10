package VehiclesExtencion;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle() {
    }

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }
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


    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if(fuelQuantity>0){
            this.fuelQuantity = fuelQuantity;
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

}
