package servicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import datos.IUsuariosDAO;
import datos.UsuariosDAO;
import modelo.Usuario;

 

public class Servicios implements IServicios {

	private IUsuariosDAO usudatos= new UsuariosDAO();
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	
	@Override
	public void altaUsuario(Usuario usuario) {

		if(!usuario.getNombre_completo().isEmpty() || 
				!usuario.getFecha().isEmpty() || 
				!usuario.getCiudad_residencia().isEmpty()||
				!usuario.getMail().isEmpty()) {
			
			usudatos.altaUsuario(usuario);
			
		} else {
			
			logger.error("Existen campos vacios");
			System.out.println("Campos vacios, la acción no puede realizarse.");
			
		}
	
				
	}

	@Override
	public void bajaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if(!usuario.getNombre_completo().isEmpty() || 
				!usuario.getFecha().isEmpty() || 
				!usuario.getCiudad_residencia().isEmpty()||
				!usuario.getMail().isEmpty()) {
			
			usudatos.modificarUsuario(usuario);
			
		} else { 
			
			logger.error("Existen campos vacíos"); 
			System.out.println("Campos vacíos, la acción no puede realizarse");
		}
		
	}

	@Override
	public void mostrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean comprobacionUsuarioDuplicado(String email) {
		// TODO Auto-generated method stub
		
		boolean respuesta = false;
		if(!email.isEmpty()) {
			respuesta = usudatos.comprobacionUsuarioDuplicado(email);
		}else {
			System.out.println("El email que has introducido esta vacio");
		}
		
		return respuesta;
	}

	@Override
	public Usuario buscarUsuario(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

}
