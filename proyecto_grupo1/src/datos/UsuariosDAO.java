package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Usuario;
import conexion.Conexion;

public class UsuariosDAO extends Conexion implements IUsuariosDAO {

	private static final Logger logger = LogManager.getLogger("Mensaje");

	@Override
	/**
	 * Pasamos como parametro un usuario, después preparamos la consulta indicando el nombre de la tabla 
	 * correspondiente y mediante ? indicamos el numero de campos de la tabla.
	 * 
	 * Ejecutamos después la consulta y si no ocurre ningún fallo indica mediante mensaje de texto que el 
	 * usuario ha sido dado de alta.
	 * 
	 * 
	 * @author Grupo 1
	 */
	public void altaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

		String consulta = "INSERT INTO usuario VALUES(?,?,?,?,?)";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, 0);
			sentencia.setString(2, usuario.getNombre_completo());
			sentencia.setString(3, usuario.getFecha());
			sentencia.setString(4, usuario.getCiudad_residencia());
			sentencia.setString(5, usuario.getMail());
			sentencia.execute();

			System.out.println("el usuario " + usuario.getNombre_completo() + " se ha dado de alta");
			logger.info("el usuario se ha dado de alta");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("el usuario NO se ha dado de alta ");
			System.out.println("No se ha podido realizar el alta del usuario");

		}

	}

	@Override
	public void eliminarUsuario(Usuario nom_usuario) {
		// TODO Auto-generated method stub

		String consulta = "DELETE FROM usuario WHERE mail=?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			
			sentencia.setString(1, nom_usuario.getMail());
			
			sentencia.execute();

			System.out.println("el usuario se ha eliminado correctamente");
			logger.info("el usuario se ha eliminado correctamente");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("el usuario NO se ha dado de baja");
			System.out.println("No se ha podido realizar la baja del usuario");

		}
		
	}

	@Override
	public void modificarUsuario(Usuario nom_usuario) {
		// TODO Auto-generated method stub
		String consulta = "UPDATE usuario SET nombre= ? ,fechaNacimiento=?,ciudadResidencia=? "
				+ "WHERE idUsuario = ? AND mail=?";


        try {
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            
            
            sentencia.setString(1,nom_usuario.getNombre_completo() );
            sentencia.setString(2,nom_usuario.getFecha() );
            sentencia.setString(3,nom_usuario.getCiudad_residencia() );
            sentencia.setInt(4,nom_usuario.getIdUsuario());
            sentencia.setString(5,nom_usuario.getMail() );
            sentencia.execute();

            System.out.println("el usuario "+nom_usuario.getNombre_completo()+" se ha modificado");
            logger.info("el usuario se ha modificado" );
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.info("el usuario NO se ha modificado " );
            System.out.println("No se ha podido realizar la modificacion del usuario");
            
        }
     
	}

	@Override
	public void mostrarUsuario(Usuario usuario) {

		System.out.println("Nombre:" + usuario.getNombre_completo() +
				" email: "+ usuario.getMail() +
				" Fecha de nacimiento: "+ usuario.getFecha() +
				" Ciudad de residencia: " + usuario.getCiudad_residencia());
	}

	@Override
	public boolean comprobacionUsuarioDuplicado(String email) {
		// TODO Auto-generated method stub
		String consulta = "SELECT * FROM usuario WHERE mail=?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, email);
			sentencia.execute();

			logger.info("El usuario con ese email existe ");
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("Retorna true porque el usuario no existe");
		}

		return false;
	}

	@Override
	public Usuario buscarUsuario(String email) {
		// TODO Auto-generated method stub
		String consulta = "SELECT * FROM usuario WHERE mail=?";
		
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta); 
			sentencia.setString(1, email);
			sentencia.execute(); 
			ResultSet rs = sentencia.executeQuery(consulta); 
			if (!rs.next()) {
				return null;
			}
			return (new Usuario(rs.getInt("idusuario"), rs.getString("nombre"), rs.getString("fechaNacimiento"),
					rs.getString("ciudadResidencia"), rs.getString("mail"))); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info("Retorna true porque el usuario no existe");
		}
		
		return null;
	}

}
