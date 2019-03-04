package controlador;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.Menu;
import lectura.LeerDatos;
import modelo.Categoria;
import modelo.Peliculas;
import modelo.Usuario;
import servicios.Servicios;
import servicios.IServicios;

public class Control {

	private final String regexp = "\\d{4}-\\d{1,2}-\\d{1,2}";
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
				modificarUsuario();
				;
				break;
			case "3":
				eliminarUsuario();
				break;
			case "4":
				mostrarUsuario();
				break;
			case "5":
				addPeliculas();
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

	/**
	 * Añade un nuevo usuario. También comprueba si ese usuario ya existe, si ya
	 * está registrado lo indica mediante mensaje de texto
	 * 
	 * @author Grupo 1
	 * 
	 * 
	 */
	public void altaUsuario() {
		logger.info("Selecionada la opcion de registro");
		String nombre = LeerDatos.LeerString("Introduce tu nombre: ");
		String fechaNacimiento = LeerDatos.LeerString("Introduce tu fecha de nacimiento: ");
		String poblacion = LeerDatos.LeerString("Introduce tu poblacion: ");
		String mail = LeerDatos.LeerString("Introduce tu email");

		if (!Pattern.matches(regexp, fechaNacimiento)) {

			System.out.println("Error,introduce la fecha en formato YYYY-MM-DD");
			mail = LeerDatos.LeerString("Introduce tu email");
		}
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

	public void addPeliculas() {

		logger.info("Selecionada la opcion de registro");
		String nombre = LeerDatos.LeerString("Introduce el nombre de pelicula: ");
		String anio = LeerDatos.LeerString("Introduce la fecha de la pelicula: ");
		if (!Pattern.matches(regexp, anio)) {

			System.out.println("Error,introduce la fecha en formato YYYY-MM-DD");
			anio = LeerDatos.LeerString("Introduce la fecha");
		}

		int idCategoria = 0;

		boolean respuesta = false;
		while (respuesta != true) {
			String nombreCategoria = LeerDatos.LeerString("Introduce el nombre de la categoria de la pelicula: ");

			Categoria c = s.buscarCategoria(nombreCategoria);

			if (c == null) {
				System.out.println("La categoria que has introducido no existe");
			} else {
				idCategoria = c.getIdCategoria();
				respuesta = true;
			}

		}

		if (s.comprobacionPeliculaDuplicada(nombre, anio)) {

			Peliculas pelicula = new Peliculas(0, nombre, anio, idCategoria);
			s.addPeliculas(pelicula);
		} else {
			logger.error("Imposible registrar pelicula, esa pelicula ya existe");
			System.out.println("Esta pelicula ya existe en nuestra base de datos.");
		}

	}

	public void mostrarUsuario() {
		String mail = LeerDatos.LeerString("Introduce el email del usuario: ");
		Usuario user = s.buscarUsuario(mail);
		s.mostrarUsuario(user);

	}

	public void addCategoria() {
		logger.info("Selecionada la opcion de registro");
		String nombreCategoria = LeerDatos.LeerString("Introduce el nombre de la categoria: ");

		if (s.comprobacionCategoriaDuplicada(nombreCategoria)) {

			Categoria categoria = new Categoria(0, nombreCategoria);
			s.addCategoria(categoria);
		} else {
			logger.error("Imposible registrar la categoría, ese nombre ya existe");
			System.out.println("La categoría que intenta registrar ya ha sido introducida.");
		}

	}

	public void listarPeliculas() {
		ArrayList<Peliculas> lista = new ArrayList<>();
		lista = s.listarPeliculas(); 
		if (!lista.isEmpty()) {
			for (Peliculas p : lista) {
				System.out.println(p.toString());
			}

		} else {
			logger.error("Imposible listar películas, la lista está vacía");
			System.out.println("La lista de películas está vacía"); 
		}

	}
}
