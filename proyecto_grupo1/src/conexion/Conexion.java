package conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class Conexion {

	Connection conexion;
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	public Conexion() {
		try {
			//Cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establecemos la conexion con la Base de Datos
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.101.103/bdmvieflix", "root", "");

		} catch (ClassNotFoundException | SQLException ex) {
			logger.error("No se ha podido realizar la conexión.");
		}

	}
}