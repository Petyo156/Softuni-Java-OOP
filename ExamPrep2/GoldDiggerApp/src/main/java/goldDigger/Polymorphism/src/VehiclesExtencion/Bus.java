package VehiclesExtencion;

public class Bus extends Vehicle{
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity, boolean isEmpty) {
        super(fuelQuantity, isEmpty ? fuelConsumption : fuelConsumption+1.4, tankCapacity);
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
    private boolean isEmpty;

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
