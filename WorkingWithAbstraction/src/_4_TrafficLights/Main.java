package _4_TrafficLights;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Colors[] colors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Colors::valueOf)
                .toArray(Colors[]::new);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            updateSignals(colors);
            printSignals(colors);
        }
    }

    private static void printSignals(Colors[] input) {
        for (Colors c:input) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static void updateSignals(Colors[] colors) {
        for (int i=0; i< colors.length; i++) {
            switch (colors[i]){
                case RED:
                    colors[i] = Colors.GREEN;
                    break;
                case GREEN:
                    colors[i] = Colors.YELLOW;
                    break;
                case YELLOW:
                    colors[i] = Colors.RED;
                    break;
            }
        }
    }
}
