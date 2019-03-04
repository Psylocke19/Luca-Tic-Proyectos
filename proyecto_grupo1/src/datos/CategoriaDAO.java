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
	public void addCategoria(Categoria c) {
		// TODO Auto-generated method stub

	}

	@Override
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
	public boolean comprobacionCategoriaDuplicada(String nombreCategoria) {
		// TODO Auto-generated method stub
		return false;
	}

}
