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
				modificarUsuario();;
				break;
			case "3":
				eliminarUsuario();
				break;
			case "4":
				;
				break;
			case "5":
				;
				break;
			case "6":
				System.out.println("Algo");
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
		String fechaNacimiento = LeerDatos.LeerString("Introduce tu fecha de nacimiento: ");
		String poblacion = LeerDatos.LeerString("Introduce tu poblacion: ");
		String mail = LeerDatos.LeerString("Introduce tu email");

		if (s.comprobacionUsuarioDuplicado(mail)) {

			Usuario user = new Usuario(0, nombre, fechaNacimiento, poblacion, mail);
			s.altaUsuario(user);
		} else {
			logger.error("Imposible registrar usuario, ese email ya existe");
			System.out.println("Ese email ya tiene una cuenta registrada asociada.");
		}

	}

	public void modificarUsuario() {
		String mail = LeerDatos.LeerString("Introduce tu email: ");
		Usuario user = s.buscarUsuario(mail);
		if (user != null) {
			user.setNombre_completo(LeerDatos.LeerString("Introduce tu nuevo nombre: "));
			user.setFecha(LeerDatos.LeerString("Introduce la nueva fecha de nacimiento: "));
			user.setCiudad_residencia(LeerDatos.LeerString("Introduce tu nueva población: "));
			s.modificarUsuario(user);
		} else {
			logger.error("No se ha encontrado un usuario con ese email");
			System.out.println("No se ha encontrado este usuario");
		}
	}
	
	public void eliminarUsuario() {
		String mail = LeerDatos.LeerString("Introduce tu email: ");
		Usuario user = s.buscarUsuario(mail);
		if (user != null) {
			s.eliminarUsuario(user);
		} else {
			logger.error("No se ha encontrado un usuario con ese email");
			System.out.println("No se ha encontrado este usuario");
		}
		
	}

}
