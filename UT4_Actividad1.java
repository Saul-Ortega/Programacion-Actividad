import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Collections;

public class UT4_Actividad1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//VARIABLES
		int number_of_iterations;
		int counter_of_iterations = 0;
		
		//MENSAJES
		String message_iterations = "Introduce el número de coches que quieres introducir";
		String message_license = "Introduce la matrícula del coche";
		String message_brand = "Introduce el modelo del coche";
		String message_matriculation_date = "Introduce la fecha de matriculación en el siguiente formato: 12052004";
		String message_is_electric = "Introduce si el coche es eléctrico o no";
		
		number_of_iterations = errorManagementInt(keyboard, message_iterations);
		
		ArrayList<Car> car_list = new ArrayList<Car>();
		
		do {
			Car ask_car = new Car();
			String license = ask_car.readLicense(keyboard, message_license);
			String brand = ask_car.readBrand(keyboard, message_brand);
			int matriculation_date = ask_car.readMatriculationDate(keyboard, message_matriculation_date);
			boolean is_electric = ask_car.readElectric(keyboard, message_is_electric);
			
			ask_car.setLicense(license);
			ask_car.setBrand(brand);
			ask_car.setMatriculation_date(matriculation_date);
			ask_car.setIs_electric(is_electric);
			car_list.add(ask_car);
			
			counter_of_iterations++;
			
		} while (counter_of_iterations < number_of_iterations);
		
		System.out.println("LISTA SIN ORDENAR");
		for (Car car:car_list) {
			System.out.println(car.toString());
		}
		
		Collections.sort(car_list);
		
		System.out.println("LISTA ORDENADA");
		for (Car car:car_list) {
			System.out.println(car.toString());
		}
		
		System.out.println("El coche más antiguo es: ");
		System.out.print(car_list.get(0).toString());
		
		System.out.println("El coche más moderno es: ");
		System.out.print(car_list.get(car_list.size()).toString());
		
		System.out.println("COCHES ELÉCTRICOS");
		for (Car car:car_list) {
			if (car.getIsElectric()) {
				System.out.println(car.toString());
			}
		}
		
	}
	public static int errorManagementInt(Scanner keyboard, String message) {
		int number = 0;
		
		do {
			try {
				System.out.println(message);
				number = keyboard.nextInt();
				
				if (number <= 0) {
					String error_message = "ERROR: has introducido un número inferior o igual a 0";
					System.out.println(error_message);
				}
				
			} catch (InputMismatchException e) {
				String error_message = "ERROR: has introducido un formato incorrecto";
				System.out.println(error_message);
				keyboard.next();
			} catch (Exception e) {
				String error_message = "ERROR: ha surjido una excepción general";
				System.out.println(error_message);
				keyboard.next();
			}
		} while (number <= 0);
		
		return number;
	}
}
