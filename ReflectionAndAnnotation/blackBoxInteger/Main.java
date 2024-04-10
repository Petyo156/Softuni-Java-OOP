package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);


        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> privateConstructor = blackBoxIntClass.getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = privateConstructor.newInstance();

        String input = scanner.nextLine();
        while(!"END".equals(input)){
            String[] arr = input.split("_");
            String command = arr[0]; int value = Integer.parseInt(arr[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(command, int.class);
            method.setAccessible(true);

            method.invoke(blackBoxInt, value);

            Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }

    }
}
