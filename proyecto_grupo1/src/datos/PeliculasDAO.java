package datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Peliculas;
import conexion.Conexion;



public class PeliculasDAO extends Conexion implements IPeliculasDAO {
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	public void addPelicula(Peliculas p) {
		
		String consulta = "INSERT INTO usuario VALUES(?,?,?,?,?)";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, 0);
			sentencia.setString(2, p.getNombre());
			sentencia.setString(3, p.getAnio());
			sentencia.setInt(4, p.getNum_categoria());
			sentencia.execute();

			System.out.println("la pel�cula " + p.getNombre() + " se ha dado de alta");
			logger.info("La pelicula se ha dado de alta");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("la pel�cula NO se ha dado de alta ");
			System.out.println("No se ha podido realizar el alta de la pel�cula");

		}
	}

	@Override
	public void addPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		
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
	public void listarPeliculas() {
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
	public boolean comprobacionPeliculaDuplicada(String nombre, int anio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Peliculas buscarPeliculas(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}
