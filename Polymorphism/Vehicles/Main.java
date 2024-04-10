package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //"Car {fuel quantity} {liters per km}"
        //"Truck {fuel quantity} {liters per km}
        Scanner scanner = new Scanner(System.in);

        String[] carArr = scanner.nextLine().split(" ");
        Car car = new Car(Double.parseDouble(carArr[1]), Double.parseDouble(carArr[2]));

        String[] truckArr = scanner.nextLine().split(" ");
        Truck truck = new Truck(Double.parseDouble(truckArr[1]), Double.parseDouble(truckArr[2]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            double temp = Double.parseDouble(input[2]);
            switch (input[0]){
                case "Drive":
                    switch (input[1]){
                        case "Car":
                            car.drive(temp);
                            break;
                        case "Truck":
                            truck.drive(temp);
                            break;
                    }
                    break;
                case "Refuel":
                    switch (input[1]){
                        case "Car":
                            car.fuel(temp);
                            break;
                        case "Truck":
                            truck.fuel(temp);
                            break;
                    }
                    break;
            }
        }
        System.out.println("Car: "+ car.getFuelQuantity());
        System.out.println("Truck: "+ truck.getFuelQuantity());
    }
}
