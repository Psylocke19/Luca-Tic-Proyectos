package controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.Menu;
import lectura.LeerDatos;
import modelo.Usuario;
import servicios.Servicios;
import servicios.IServicios;

public class Control {

	IServicios s = new Servicios();
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	public Control() {
	
		boolean salida = false;
		
		while (salida == false) {
		Menu.Menu();
		String opt = LeerDatos.LeerString();

		switch (opt) {

		case "1":
			altaUsuario();
			break;
		case "2":
			;
			break;
		case "3":
			;
			break;
		case "4":
			;
			break;
		case "5":
			;
			break;
		case "6":
			;
			break;
		case "7":
			salida = true;
			break;
		default:
			System.out.println("Opcion no valida;");
		}

	}
}
		
	
	
	public void altaUsuario() {
		logger.info("Selecionada la opcion de registro");
		String nombre = LeerDatos.LeerString("Introduce tu nombre: ");
		String fechaNacmiento = LeerDatos.LeerString("Introduce tu fecha de nacimiento: ");
		String poblacion = LeerDatos.LeerString("Introduce tu poblacion: ");
		String mail = LeerDatos.LeerString("Introduce tu email");
		
		if(s.comprobacionUsuarioDuplicado(mail)) {
			Usuario user = new Usuario(0,nombre,fechaNacmiento,poblacion,mail);
			s.altaUsuario(user);
		}else {
			logger.error("Imposible registrar usuario, ese email ya existe");
			System.out.println("Ese email ya tiene una cuenta registrada asociada.");
		}
		
		
		
		
	}
	
	
	
}
