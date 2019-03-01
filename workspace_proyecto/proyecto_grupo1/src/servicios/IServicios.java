package servicios;

import modelo.Usuario;

public interface IServicios {

	public void altaUsuario(Usuario usuario);
    public void bajaUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public void mostrarUsuario(Usuario usuario);
    public boolean comprobacionUsuarioDuplicado(String email);
	
	
}