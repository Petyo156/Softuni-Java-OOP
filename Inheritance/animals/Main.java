package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String params = scanner.nextLine();

        while(!type.equals("Beast!") && !params.equals("Beast!")){

            String[] arr = params.split(" ");
            String name = arr[0]; int age = Integer.parseInt(arr[1]); String gender = arr[2];

            try {
                switch (type) {
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

            type = scanner.nextLine();
            params = scanner.nextLine();
        }
    }
}
