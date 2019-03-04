package servicios;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import datos.CategoriaDAO;
import datos.ICategoriaDAO;
import datos.IPeliculasDAO;
import datos.IUsuariosDAO;
import datos.PeliculasDAO;
import datos.UsuariosDAO;
import modelo.Categoria;
import modelo.Peliculas;
import modelo.Usuario;

public class Servicios implements IServicios {

	private IUsuariosDAO usudatos = new UsuariosDAO();
	private IPeliculasDAO pelidatos = new PeliculasDAO();
	private ICategoriaDAO catedatos = new CategoriaDAO();
	private static final Logger logger = LogManager.getLogger("Mensaje");

	@Override
	/**
	 * Si el campo está vacío se llama a la interfaz correspondiente, sino se
	 * muestra un mensaje de texto indicando que no es posible realizar la acción.
	 * 
	 * @author Grupo 1
	 */
	public void altaUsuario(Usuario usuario) {

		if (!usuario.getNombre_completo().isEmpty() || !usuario.getFecha().isEmpty()
				|| !usuario.getCiudad_residencia().isEmpty() || !usuario.getMail().isEmpty()) {

			usudatos.altaUsuario(usuario);

		} else {

			logger.error("Existen campos vacios");
			System.out.println("Campos vacios, la acción no puede realizarse.");

		}

	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usudatos.eliminarUsuario(usuario);

	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if (!usuario.getNombre_completo().isEmpty() || !usuario.getFecha().isEmpty()
				|| !usuario.getCiudad_residencia().isEmpty() || !usuario.getMail().isEmpty()) {

			usudatos.modificarUsuario(usuario);

		} else {

			logger.error("Existen campos vacíos");
			System.out.println("Campos vacíos, la acción no puede realizarse");
		}

	}

	@Override
	public void mostrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

		if (!usuario.getNombre_completo().isEmpty() || !usuario.getFecha().isEmpty()
				|| !usuario.getCiudad_residencia().isEmpty() || !usuario.getMail().isEmpty()) {

			usudatos.mostrarUsuario(usuario);
		} else {
			logger.error("No se ha podido mostrar al usuario");
			System.out.println("No se ha podido mostrar al usuario");
		}

	}

	@Override
	public boolean comprobacionUsuarioDuplicado(String email) {
		// TODO Auto-generated method stub

		boolean respuesta = false;
		if (!email.isEmpty()) {
			respuesta = usudatos.comprobacionUsuarioDuplicado(email);
		} else {
			System.out.println("El email que has introducido esta vacio");
		}

		return respuesta;
	}

	@Override
	public Usuario buscarUsuario(String mail) {
		// TODO Auto-generated method stub
		if (!mail.isEmpty()) {
			return usudatos.buscarUsuario(mail);
		} else {
			System.out.println("El campo que has introducido está vacio");
		}
		return null;
	}

	@Override
	public void addPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		if (!pelicula.getNombre().isEmpty() || !pelicula.getAnio().isEmpty() || pelicula.getNum_categoria() == 0) {

			pelidatos.addPelicula(pelicula);

		} else {

			logger.error("Existen campos vacíos");
			System.out.println("Campos vacíos, la acción no puede realizarse");
		}

	}

	@Override
	public void modificarPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		if(!pelicula.getNombre().isEmpty() || !pelicula.getAnio().isEmpty()
				|| !(pelicula.getNum_categoria() == 0)) {
			
			pelidatos.modificarPeliculas(pelicula);
			
		} else {
			logger.error("Existen campos vacíos");
			System.out.println("Campos vacíos, la acción no puede realizarse");
		}
		
	}

	@Override
	public void eliminarPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		pelidatos.eliminarPeliculas(pelicula);

	}


	@Override
	public void listarPorMasVistas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarPorMasValoradas() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarPorNoVistas() {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean comprobacionPeliculaDuplicada(String nombre, String anio) {
		boolean respuesta = false;
		if (!nombre.isEmpty() || !anio.isEmpty()) {
			respuesta = pelidatos.comprobacionPeliculaDuplicada(nombre, anio);
		} else {
			System.out.println("Los campos nombre y año introducidos estan vacios");
		}

		return respuesta;
	}

	@Override
	public Categoria buscarCategoria(String nombre) {
		// TODO Auto-generated method stub
		if (!nombre.isEmpty()) {
			Categoria c = catedatos.buscarCategoria(nombre);
			if (c != null) {
				return c;
			} else {
				System.out.println("Esa categoria no existe");
			}
		} else {
			System.out.println("El nombre esta vacio");
		}
		return null;
	}

	@Override
	/**
	 * En este caso, una vez rellenados los campos de añadir categoría se comprueba si alguno de ellos están vacíos.
	 * Si no es así, se añade. Si hay algún campo incomplemento se envía un mensaje de error y la acción no se lleva a cabo
	 * 
	 * @author Grupo 1
	 */
	public void addCategoria(Categoria c) {

		if (!c.getNombreCategoria().isEmpty()) {

			catedatos.addCategoria(c);

		} else {

			logger.error("Existen campos vacíos");
			System.out.println("Campos vacíos, la acción no puede realizarse");
		}

	}

	@Override
	public boolean comprobacionCategoriaDuplicada(String nombreCategoria) {
		boolean respuesta = false;
		if (!nombreCategoria.isEmpty()) {
			respuesta = catedatos.comprobacionCategoriaDuplicada(nombreCategoria);
		} else {
			System.out.println("El campo nombre de la categoria introducido está vacios");
		}
		return respuesta;
	}

	@Override
	public ArrayList<Peliculas> listarPeliculas() {

		try {
			
			return pelidatos.listarPeliculas();

		} catch (Exception e) {
			logger.error("No se ha podido listar las peliculas");
			System.out.println("No se ha podido listar las peliculas");
		}
		return null;
	}

	@Override
	public Peliculas buscarPelicula(String nombre) {
		// TODO Auto-generated method stub
		if (!nombre.isEmpty()) {
			Peliculas p = pelidatos.buscarPeliculas(nombre);
			if (p != null) {
				return p;
			} else {
				System.out.println("Esta pelicula no existe");
			}
		} else {
			System.out.println("El nombre esta vacio");
		}
		return null;
	}

}
