package _3_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String b = scanner.nextLine();
        String a = scanner.nextLine();


        int res = Suits.valueOf(a).getPower() + Ranks.valueOf(b).getPower() ;
        System.out.printf("Card name: %s of %s; Card power: %d", b, a, res);
    }
}
