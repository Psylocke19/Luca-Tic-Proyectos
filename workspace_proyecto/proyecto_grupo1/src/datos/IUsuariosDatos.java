package datos;

import modelo.Usuario;
public interface IUsuariosDatos {

	public void AltaUsuario(Usuario usuario);
    public void BajaUsuario(Usuario usuario);
    public void ModificarUsuario(Usuario usuario);
    public void MostrarUsuario(Usuario usuario);
    public boolean ComprobacionUsuarioDuplicado(String email);
    
    
    
}
