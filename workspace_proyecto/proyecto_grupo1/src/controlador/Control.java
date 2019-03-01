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
	
		Menu.Menu();
		
	}
	
	public void altaUsuario() {
		logger.info("Selecionada la opcion de registro");
		String nombre = LeerDatos.LeerString("Introduce tu nombre: ");
		String fechaNacmiento = LeerDatos.LeerString("Introduce tu fecha de nacimiento: ");
		String poblacion = LeerDatos.LeerString("Introduce tu poblacion: ");
		String mail = LeerDatos.LeerString("Introduce tu email");
		
		if(s.comprobarMailDuplicado(mail)) {
			Usuario user = new Usuario(0,nombre,fechaNacmiento,poblacion,mail);
			s.altaUsuario(user);
		}else {
			logger.error("Imposible registrar usuario, ese email ya existe");
			System.out.println("Ese email ya tiene una cuenta registrada asociada.");
		}
		
		
		
		
	}
	
	
	
}
