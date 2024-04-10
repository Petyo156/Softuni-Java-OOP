package Vehicles;

public class Car extends Vehicle{

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption+0.9);
    }

    @Override
    void fuel(double fuel) {
        super.setFuelQuantity(getFuelQuantity()+fuel);
    }
}
