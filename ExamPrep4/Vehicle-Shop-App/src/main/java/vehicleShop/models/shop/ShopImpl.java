package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop {
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();
        for (Tool tool : tools) {
            if (!tool.isUnfit() && worker.canWork() && !vehicle.reached()) {
                worker.working();
                tool.decreasesPower();
                vehicle.making();
            }
        }
    }
}
