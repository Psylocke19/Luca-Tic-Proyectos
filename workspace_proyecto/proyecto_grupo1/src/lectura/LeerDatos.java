package lectura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerDatos {
	
	public static String LeerString() {
		return new Scanner(System.in).nextLine();
	}

	public static String LeerString(String msg) {
		System.out.println(msg);
		return new Scanner(System.in).nextLine();
	}
	
	
	public static int LeerInt(String msg) {
		try {
			System.out.println(msg);
		return new Scanner(System.in).nextInt();
		}catch(InputMismatchException e) {
			System.out.println("El caracter introducido no es valido");
		}
		
		return 0;
	}
	
	public static double LeerDouble(String msg) {
		try {
			System.out.println(msg);
			return new Scanner(System.in).nextDouble();
			}catch(InputMismatchException e) {
				System.out.println("El caracter introducido no es valido");
			}
			
			return 0;
	}
}
