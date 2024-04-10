package VehiclesExtencion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Vehicle {initial fuel quantity} {liters per km} {tank capacity}
        Scanner scanner = new Scanner(System.in);
        Bus bus = null; Car car = null; Truck truck = null;
        for (int i = 0; i < 3; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]){
                case "Bus":
                    bus = new Bus(Double.parseDouble(command[1]),
                            Double.parseDouble(command[2]), Double.parseDouble(command[3]),false);
                    break;
                case "Car":
                    car = new Car(Double.parseDouble(command[1]),
                            Double.parseDouble(command[2]), Double.parseDouble(command[3]));
                    break;
                case "Truck":
                    truck = new Truck(Double.parseDouble(command[1]),
                            Double.parseDouble(command[2]), Double.parseDouble(command[3]));
                    break;
            }
        }
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]){
                case "Drive":
                    switch (command[1]){
                        case "Car":
                            car.drive(Double.parseDouble(command[2]));
                            break;
                        case "Truck":
                            truck.drive(Double.parseDouble(command[2]));
                            break;
                        case "Bus":
                            bus.drive(Double.parseDouble(command[2]));
                            break;
                    }
                    break;
                case "DriveEmpty":
                    switch (command[1]){
                        case "Bus":
                            bus.setEmpty(true);
                            bus.drive(Double.parseDouble(command[2]));
                            break;
                    }
                    break;
                case "Refuel":
                    switch (command[1]){
                        case "Car":
                            car.fuel(Double.parseDouble(command[2]));
                            break;
                        case "Truck":
                            truck.fuel(Double.parseDouble(command[2]));
                            break;
                        case "Bus":
                            bus.fuel(Double.parseDouble(command[2]));
                            break;
                    }
                    break;
            }
        }
        System.out.println("Car: "+ car.getFuelQuantity());
        System.out.println("Truck: "+ truck.getFuelQuantity());
        System.out.println("Bus: "+bus.getFuelQuantity());
    }
}
