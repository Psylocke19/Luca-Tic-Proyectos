package servicios;

import modelo.Categoria;
import modelo.Peliculas;
import modelo.Usuario;

public interface IServicios {

	
	public void altaUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public void mostrarUsuario(Usuario usuario);
    public boolean comprobacionUsuarioDuplicado(String email);
    public Usuario buscarUsuario(String mail); 
	
    public void addPeliculas(Peliculas pelicula);
    public void modificarPeliculas(Peliculas pelicula);
    public void eliminarPeliculas(Peliculas pelicula);
    public void listarPeliculas();
    public void listarPorMasVistas();
    public void listarPorMasValoradas();
    public void listarPorNoVistas();
    public boolean comprobacionPeliculaDuplicada(String nombre,String anio);
    public Usuario buscarPelicula(String nombre); 
    
    public void addCategoria(Categoria c); 
	public Categoria buscarCategoria(String nombreCategoria); 
	public boolean comprobacionCategoriaDuplicada(String nombreCategoria); 
	
	
}
