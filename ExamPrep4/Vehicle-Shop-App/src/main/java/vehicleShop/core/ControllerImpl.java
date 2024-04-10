package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Worker> workerRepository;
    private Repository<Vehicle> vehicleRepository;
    private Shop shop;


    public ControllerImpl() {
        workerRepository = new WorkerRepository();
        vehicleRepository = new VehicleRepository();
        shop = new ShopImpl();
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;
        switch (type) {
            case "FirstShift":
                worker = new FirstShift(workerName);
                break;
            case "SecondShift":
                worker = new SecondShift(workerName);
                break;
            default:
                throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }
        workerRepository.add(worker);
        return String.format(ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        vehicleRepository.add(vehicle);
        return String.format(SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = workerRepository.findByName(workerName);
        if (null == worker) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Tool tool = new ToolImpl(power);
        worker.getTools().add(tool);
        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> workers = workerRepository.getWorkers().stream()
                .filter(worker -> worker.getStrength() > 70)
                .collect(Collectors.toList());
        if (workers.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }
        Vehicle vehicle = vehicleRepository.findByName(vehicleName);
        int brokenTools = 0;
        for (Worker worker : workers) {
            shop.make(vehicle, worker);
            for (Tool tool : worker.getTools()) {
                if (tool.isUnfit()) {
                    brokenTools++;
                }
            }
            //!
            if (vehicle.reached()) {
                break;
            }
        }

        String doneOrNot = "";
        if (vehicle.reached()) {
            doneOrNot = "done";
        } else {
            doneOrNot = "not done";
        }

        return String.format(VEHICLE_DONE, vehicleName, doneOrNot)
                + String.format(COUNT_BROKEN_INSTRUMENTS, brokenTools);
    }

    @Override
    public String statistics() {
        int vehiclesReady = 0;
        for (Vehicle vehicle : vehicleRepository.getWorkers()) {
            if (vehicle.reached()) {
                vehiclesReady++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d vehicles are ready!", vehiclesReady));
        sb.append(System.lineSeparator());
        sb.append("Info for workers:");
        sb.append(System.lineSeparator());

        for (Worker worker : workerRepository.getWorkers()) {
            int toolsLeft = 0;//!
            for (Tool tool : worker.getTools()) {
                if (!tool.isUnfit()) {
                    toolsLeft++;
                }
            }
            sb.append(String.format("Name: %s, Strength: %d", worker.getName(), worker.getStrength()));
            sb.append(System.lineSeparator());
            sb.append(String.format("Tools: %d fit left", toolsLeft));
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}