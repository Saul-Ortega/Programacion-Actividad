import java.util.Scanner;

public class Car implements Comparable<Car>{
	//ATRIBUTOS
	private String license;
	private String brand;
	private int matriculation_date;
	private boolean electric;
	
	//CONSTRUCTORES
	public Car() {
		
	}

	public Car(String license, String brand, int matriculation_date, boolean electric) {
		this.license = license;
		this.brand = brand;
		this.matriculation_date = matriculation_date;
		this.electric = electric;
	}
	
	//GETTER
	String getLicense() {
		return license;
	}
	
	String getBrand() {
		return brand;
	}
	
	int getMatriculationDate() {
		return matriculation_date;
	}
	
	boolean getIsElectric() {
		return electric;
	}
	
	public boolean isElectric() {
		return electric;
	}

	//SETTER
	public void setLicense(String license) {
		this.license = license;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setMatriculation_date(int matriculation_date) {
		this.matriculation_date = matriculation_date;
	}

	public void setIs_electric(boolean electric) {
		this.electric = electric;
	}

	//MÉTODO TO STRING
	@Override
	public String toString() {
		return "Car [license=" + license + ", brand=" + brand + ", matriculation_date=" + matriculation_date
				+ ", electric=" + electric + "]";
	}	
	
	//MÉTODO COMPARE TO
	@Override
	public int compareTo(Car o) {
		return this.getMatriculationDate() - o.getMatriculationDate();
	}
	

	//MÉTODOS PARA LEER POR CONSOLA
	public String readLicense(Scanner keyboard, String message) {
		String ask_license = "";
		boolean keep_going = true;
		
		do {
			try {
				keep_going = true;
				System.out.println(message);
				ask_license = keyboard.next();
				
				for (int i = 0; i < ask_license.length(); i++) {
					if (!Character.isDigit(ask_license.charAt(i)) && !Character.isLetter(ask_license.charAt(i))) {
						keep_going = false;
					}
				}				
			} catch (Exception e) {
				String error_message = "ERROR: ha surjido una excepción";
				System.out.println(error_message);
			}
			
		} while (!keep_going);
	
		return ask_license;
	}
	public String readBrand(Scanner keyboard, String message) {
		String ask_brand = "";
		boolean keep_going = true;
		
		do {
			try {
				keep_going = true;
				System.out.println(message);
				ask_brand = keyboard.next();
				
				for (int i = 0; i < ask_brand.length(); i++) {
					if (!Character.isDigit(ask_brand.charAt(i)) && !Character.isLetter(ask_brand.charAt(i))) {
						keep_going = false;
					}
				}				
			} catch (Exception e) {
				String error_message = "ERROR: ha surjido una excepción";
				System.out.println(error_message);
			}
			
		} while (!keep_going);
		
		return ask_brand;
	}
	public int readMatriculationDate(Scanner keyboard, String message) {
		String ask_matriculation_date = "";
		int matriculation_date = 0;
		boolean keep_going = true;
		
		do {
			keep_going = true;
			System.out.println(message);
			ask_matriculation_date = keyboard.next();
			
			if (ask_matriculation_date.length() != 8) {
				keep_going = false;
			} else {
				for (int i = 0; i < 8; i++) {
					if (!Character.isDigit(ask_matriculation_date.charAt(i))) {
						keep_going = false;
					}
					else {
						matriculation_date = Integer.parseInt(ask_matriculation_date);
					}
				}
			}
			
			if (!keep_going) {
				String error_message = "ERROR: la fecha introducida es incorrecta";
				System.out.println(error_message);
			}
			
		} while (!keep_going);
		
		return matriculation_date;
	}
	public boolean readElectric(Scanner keyboard, String message) {
		boolean is_electric = false;
		String ask_is_electric = "";
		boolean keep_going = true;
		
		do {
			keep_going = true;
			System.out.println(message);
			ask_is_electric = keyboard.next();
			
			if (ask_is_electric.charAt(0) == 'V' ||  ask_is_electric.charAt(0) == 'v') {
				is_electric = true;
			}
			
		} while (!keep_going);
		
		return is_electric;
	}
}
