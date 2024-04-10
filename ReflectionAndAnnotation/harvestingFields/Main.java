package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

		Field[] declaredFields = richSoilLandClass.getDeclaredFields();

		String input = scanner.nextLine();
		while(!"HARVEST".equals(input)){
			switch (input){
				case "private":
					printFields(declaredFields, "private");
					break;
				case "protected":
					printFields(declaredFields, "protected");
					break;
				case "public":
					printFields(declaredFields, "public");
					break;
				case "all":
					for (Field f:declaredFields) {
						System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()),f.getType().getSimpleName(),f.getName());
					}
					break;
			}

			input = scanner.nextLine();
		}
	}

	public static void printFields(Field[] declaredFields, String param){
		Arrays.stream(declaredFields).forEach(field -> {
			if(Modifier.toString(field.getModifiers()).equals(param)){
				System.out.printf("%s %s %s%n", param,field.getType().getSimpleName(), field.getName());
			} });
	}
}
