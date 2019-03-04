package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Peliculas;
import conexion.Conexion;



public class PeliculasDAO extends Conexion implements IPeliculasDAO {
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	public void addPelicula(Peliculas p) {
		
		String consulta = "INSERT INTO peliculas VALUES(?,?,?,?)";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, 0);
			sentencia.setString(2, p.getNombre());
			sentencia.setString(3, p.getAnio());
			sentencia.setInt(4, p.getNum_categoria());
			sentencia.execute();

			System.out.println("la película " + p.getNombre() + " se ha dado de alta");
			logger.info("La pelicula se ha dado de alta");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("la película NO se ha dado de alta ");
			System.out.println("No se ha podido realizar el alta de la película");

		}
	}


	@Override
	public void modificarPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Peliculas> listarPeliculas() {
		return null;
		// TODO Auto-generated method stub
		
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
	public boolean comprobacionPeliculaDuplicada(String nombre, String anio) {
		String consulta = "SELECT * FROM peliculas WHERE nombre=? AND anio=?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, nombre);
			sentencia.setString(2, anio);
			ResultSet rs = sentencia.executeQuery(); 
			if (!rs.next()) {
				return true;
			}
			logger.info("Esa película ya existe ");
			return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("Retorna true porque la pelicula no existe");
		}

		return false;
	}		
	

	@Override
	public Peliculas buscarPeliculas(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}
