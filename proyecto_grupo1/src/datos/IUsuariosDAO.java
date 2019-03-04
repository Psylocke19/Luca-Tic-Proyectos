package datos;

import modelo.Usuario;
public interface IUsuariosDAO {

	public void altaUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public void mostrarUsuario(Usuario usuario);
    public boolean comprobacionUsuarioDuplicado(String email);
    public Usuario buscarUsuario(String email); 
	    
}
