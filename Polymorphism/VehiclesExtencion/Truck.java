package VehiclesExtencion;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption+1.6, tankCapacity);
    }

    @Override
    void fuel(double fuel) {
        if(getFuelQuantity()+fuel*0.95<=this.getTankCapacity() && fuel>=0) {
            super.setFuelQuantity(getFuelQuantity() + fuel * 0.95);
        } else {
            if(fuel<0){
                System.out.println("Fuel must be a positive number");
            } else {
                System.out.println("Cannot fit fuel in tank");
            }
        }
    }
}
