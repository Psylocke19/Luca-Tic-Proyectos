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
	 * @class Servicios
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
	/**
	 * Este método llama a la parte de Datos para que ésta elimine el usuario
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
	public void eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usudatos.eliminarUsuario(usuario);

	}

	@Override
	/**
	 * Si el campo está vacío se manda un mensaje de error, sino se realiza la
	 * modificación de usuario
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	/**
	 * Si el campo está vacío se envía un mensaje de de error, sino se muestra al
	 * usuario
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	/**
	 * Si el email introducido no está vacío se realiza la comprobación del mismo
	 * para ver si se encuentra diplicado o no en la base de datos
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	/**
	 * Si el campo está vacío aparece un mensaje de error, sino se añade la película
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	/**
	 * Si el campo está vacío se produce un error, sino se modifican los atributos
	 * de la película
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
	public void modificarPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		if (!pelicula.getNombre().isEmpty() || !pelicula.getAnio().isEmpty() || !(pelicula.getNum_categoria() == 0)) {

			pelidatos.modificarPeliculas(pelicula);

		} else {
			logger.error("Existen campos vacíos");
			System.out.println("Campos vacíos, la acción no puede realizarse");
		}

	}

	@Override
	/**
	 * Se llama al paquete de datos para que realice la eliminación de películas
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	/**
	 * Si los campos están vacíos se muestra un mensaje de nerror, sino se llama a
	 * datos para realizar la consulta sobre si la pelicula está ya presente en la
	 * base de datos
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	/**
	 * Si el campo está vacío se muestra un mensaje de error, sino se intenta
	 * añadir. Si al intentarlo se obtiene null, se muestra un mensaje de aviso que
	 * indica que la categoría que se ha intentando añadir no existe
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	 * En este caso, una vez rellenados los campos de añadir categoría se comprueba
	 * si alguno de ellos están vacíos. Si no es así, se añade. Si hay algún campo
	 * incomplemento se envía un mensaje de error y la acción no se lleva a cabo
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
	/**
	 * Si el campo está vacío se genera un aviso, sino se procede a comprobar que la
	 * base de datos no presenta ya esa categoría
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	/**
	 * En este método se genera un ArrayList donde se van almacenando todas las
	 * películas de la base de datos para posteriormente mostrarlas en forma de
	 * lista
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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
	/**
	 * Si el campo está vacío se genera un aviso, sino se procede a buscar una
	 * película en la base de datos. Si al realizar la búsqueda se obtiene null, se
	 * indica que la película en cuestión no existe
	 * 
	 * @author Grupo 1
	 * @class Servicios
	 */
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

	@Override
	public void listarPorCategorias(int idCategoria) {
		// TODO Auto-generated method stub
		if (idCategoria > 0) {

			ArrayList<Peliculas> lista = pelidatos.listarPorCategorias(idCategoria);

			if (!lista.isEmpty()) {
				for (Peliculas p : lista) {
					System.out.println(p.toString());
				}
			} else {
				System.out.println("No se ha encontrado ninguna pelicula con esa categoria");
			}
		} else {
			System.out.println("La categoria introducida no existe");
		}
	}

}
