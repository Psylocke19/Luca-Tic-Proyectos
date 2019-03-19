package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import conexion.Conexion;
import modelo.Categoria;

public class CategoriaDAO extends Conexion implements ICategoriaDAO {

	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	
	@Override
	/**
	 * Pasamos como parámetro una categoría y después preparamos la consulta indicando el nombre de la tabla correspondiente.
	 * Igualmente, mediante ? indicamos el número de campos de la tabla. 
	 * Si una vez ejecutada la consulta no ocurre ningún fallo, se indica mediante un mensaje de texto que la categoría ha sido 
	 * añadida correctamente. 
	 * 
	 * @author Grupo 1
	 * @class CategoriaDAO
	 */
	public void addCategoria(Categoria c) {
		
		String consulta = "INSERT INTO categoria VALUES(?,?)";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, 0);
			sentencia.setString(2, c.getNombreCategoria());
			
			sentencia.execute();

			System.out.println("la categoria " + c.getNombreCategoria() + " se ha aniadido");
			logger.info("La categoria se ha aniadido");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("la categoria no se ha aniadido ");
			System.out.println("no se ha podido aniadir la categoria");

		}

	}

	@Override
	/**
	 * Pasamos como parámetro una categoría y después preparamos la consulta indicando el nombre de la tabla correspondiente.
	 * Igualmente, mediante ? indicamos el número de campos de la tabla. 
	 * Si una vez ejecutada la consulta no sale el mensaje de error sobre de que la categoría introducida no existe,
	 * se indica mediante un mensaje de texto que la categoría ha sido 
	 * encontrada correctamente
	 * 
	 * @author Grupo 1
	 * @class CategoriaDAO
	 */
	public Categoria buscarCategoria(String nombreCategoria) {

		String consulta = "SELECT * FROM categoria WHERE nombreCategoria=?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, nombreCategoria);
			sentencia.execute();
			ResultSet rs = sentencia.executeQuery();
			if (!rs.next()) {
				logger.error("El nombre de la categoria introducida no existe");
				return null;
			}
			logger.info("Categoria encontrada");
			return new Categoria(rs.getInt("idCategoria"), rs.getString("nombreCategoria"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("ERROR");
		}
		return null;
	}

	@Override
	/**
	 * Pasamos como parámetro una categoría y después preparamos la consulta indicando el nombre de la tabla correspondiente.
	 * Igualmente, mediante ? indicamos el número de campos de la tabla. 
	 * A continuación se comprueba si la categoría existía ya
	 * 
	 * @author Grupo 1
	 * @class CategoriaDAO
	 */
	public boolean comprobacionCategoriaDuplicada(String nombreCategoria) {
		String consulta = "SELECT * FROM categoria WHERE nombreCategoria=? ";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, nombreCategoria);
			ResultSet rs = sentencia.executeQuery(); 
			if (!rs.next()) {
				return true;
			}
			logger.info("Esa categoria ya existe ");
			return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("ERROR");
		}

		return false;
	}

}
