package lectura;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LeerDatos {
	
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
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
			logger.error("Error, el carácter introducido no es válido"); 
			System.out.println("El carácter introducido no es válido");
		}
		
		return 0;
	}
	
	
	public static double LeerDouble(String msg) {
		try {
			System.out.println(msg);
			return new Scanner(System.in).nextDouble();
			}catch(InputMismatchException e) {
				logger.error("Error, el carácter introducido no es válido"); 
				System.out.println("El carácter introducido no es válido");
			}
			
			return 0;
	}
}
