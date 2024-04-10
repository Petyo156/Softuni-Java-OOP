package restaurant.core;

import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.Working;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.Repository;
import restaurant.repositories.WaiterRepository;

import java.util.ArrayList;
import java.util.List;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Client> clientRepository;
    private Repository<Waiter> waiterRepository;

    private int count = 0;

    public ControllerImpl() {
        clientRepository = new ClientRepository();
        waiterRepository = new WaiterRepository();
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter;
        switch (type) {
            case "FullTimeWaiter":
                waiter = new FullTimeWaiter(waiterName);
                break;
            case "HalfTimeWaiter":
                waiter = new HalfTimeWaiter(waiterName);
                break;
            default:
                throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }
        waiterRepository.add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        for (String order : orders) {
            client.getClientOrders().add(order);
        }
        clientRepository.add(client);
        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waiterRepository.getCollection()
                .stream()
                .filter(waiter1 -> waiter1.getName().equals(waiterName))
                .findFirst()
                .orElse(null);
        if (null == waiter) {
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }
        waiterRepository.remove(waiter);
        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = clientRepository.getCollection()
                .stream()
                .filter(client1 -> client1.getName().equals(clientName))
                .findFirst()
                .orElse(null);
        if (null == client) {
            throw new IllegalArgumentException(CLIENT_DOES_NOT_EXIST);
        }
        clientRepository.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        if (waiterRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        Client client = clientRepository.byName(clientName);
        Working working = new WorkingImpl();
        working.takingOrders(client, waiterRepository.getCollection());
        this.count++;
        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_CLIENTS_COUNT, count));
        sb.append(System.lineSeparator());
        sb.append(FINAL_WAITERS_STATISTICS);
        sb.append(System.lineSeparator());
        for (Waiter waiter : waiterRepository.getCollection()) {
            sb.append(String.format(FINAL_WAITER_NAME, waiter.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency()));
            sb.append(System.lineSeparator());

            String takenOrders = "";
            if(waiter.takenOrders().getOrdersList().isEmpty()){
                takenOrders = "None";
            } else {
                takenOrders = String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList());
            }

            sb.append(String.format(FINAL_WAITER_ORDERS, takenOrders));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
