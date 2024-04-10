package VehiclesExtencion;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption+0.9, tankCapacity);
    }

    @Override
    void fuel(double fuel) {
        if(getFuelQuantity()+fuel<=this.getTankCapacity() && fuel>=0) {
            super.setFuelQuantity(getFuelQuantity() + fuel);
        } else {
            if(fuel<0){
                System.out.println("Fuel must be a positive number");
            } else {
                System.out.println("Cannot fit fuel in tank");
            }
        }
    }
}
