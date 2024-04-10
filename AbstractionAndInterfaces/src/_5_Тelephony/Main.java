package _5_Тelephony;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Smartphone smartphone = new Smartphone();

        String[] numbers = scanner.nextLine().split(" ");
        for (String number:numbers) {
            smartphone.addNumber(number);
        }

        String[] sites = scanner.nextLine().split(" ");
        for (String site:sites) {
            smartphone.addUrl(site);
        }

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
