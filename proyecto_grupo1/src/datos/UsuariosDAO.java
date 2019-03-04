package datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Usuario;
import conexion.Conexion;


public class UsuariosDAO extends Conexion implements IUsuariosDAO{

    private static final Logger logger = LogManager.getLogger("Mensaje");

	@Override
	public void altaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
        String consulta = "INSERT INTO partido VALUES(?,?,?,?,?)";


        try {
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            
            sentencia.setInt(1,usuario.getIdUsuario() );
            sentencia.setString(2,usuario.getNombre_completo() );
            sentencia.setString(3,usuario.getFecha() );
            sentencia.setString(4,usuario.getCiudad_residencia() );
            sentencia.setString(5,usuario.getMail() );
            sentencia.execute();

            System.out.println("el usuario "+usuario.getNombre_completo()+" se ha dado de alta");
            logger.info("el usuario se ha dado de alta" );
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.info("el usuario NO se ha dado de alta " );
            System.out.println("No se ha podido realizar el alta del usuario");
            
            
        }
		
	}

	@Override
	public void bajaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean comprobacionUsuarioDuplicado(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario buscarUsuario(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

}
