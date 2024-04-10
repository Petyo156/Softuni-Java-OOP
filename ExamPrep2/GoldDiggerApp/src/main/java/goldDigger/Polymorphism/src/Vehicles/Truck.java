package Vehicles;

public class Truck extends Vehicle{

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption+1.6);
    }

    @Override
    void fuel(double fuel) {
        super.setFuelQuantity(getFuelQuantity()+fuel*0.95);
    }
}
