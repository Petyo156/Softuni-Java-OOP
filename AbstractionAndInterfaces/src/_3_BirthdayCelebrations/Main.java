package _3_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //"Citizen {name} {age} {id} {birthdate}"
        //"Robot {model} {id}"
        //"Pet {name} {birthdate}"

        List<Birthable> birthableList = new ArrayList<>();
        while (!input.equals("End")) {
            String[] arr = input.split(" ");
            String nameOrModel = arr[1];

            switch (arr[0]) {
                case "Citizen":
                    int age = Integer.parseInt(arr[2]);
                    String id = arr[3];
                    String birthdate = arr[4];
                    Citizen citizen = new Citizen(nameOrModel, age, id, birthdate);
                    birthableList.add(citizen);
                    break;
                case "Pet":
                    String birthdatePet = arr[2];
                    Pet pet = new Pet(nameOrModel, birthdatePet);
                    birthableList.add(pet);
                    break;
                case "Robot":
                    break;
            }
            input = scanner.nextLine();
        }
        int year = Integer.parseInt(scanner.nextLine());

        for (Birthable b:birthableList) {
            String dateOfB = b.getBirthDate();
            int yearOfB = Integer.parseInt(dateOfB.split("/")[2]);
            if(year == yearOfB){
                System.out.println(dateOfB);
            }
        }
    }
}
