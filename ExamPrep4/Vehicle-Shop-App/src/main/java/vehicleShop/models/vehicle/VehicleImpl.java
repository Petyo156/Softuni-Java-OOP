package vehicleShop.models.vehicle;

import static vehicleShop.common.ExceptionMessages.*;

public class VehicleImpl implements Vehicle {
    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        setName(name);
        setStrengthRequired(strengthRequired);
    }

    private void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    private void setName(String name) {
        if (null == name || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrengthRequired() {
        return strengthRequired;
    }

    @Override
    public boolean reached() {
        return strengthRequired == 0;
    }

    @Override
    public void making() {
        strengthRequired -= 5;
        if (strengthRequired < 0) {
            strengthRequired = 0;
        }
    }
}
