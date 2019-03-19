package datos;

import java.util.ArrayList;

import modelo.Peliculas;

public interface IPeliculasDAO {
	public void addPelicula(Peliculas pelicula);
	public void modificarPeliculas(Peliculas pelicula);
    public void eliminarPeliculas(Peliculas pelicula);
    public ArrayList<Peliculas> listarPeliculas();
    public void listarPorMasVistas();
    public void listarPorMasValoradas();
    public ArrayList<Peliculas> listarPorCategorias(int idCategoria);
    public boolean comprobacionPeliculaDuplicada(String nombre,String anio);
    public Peliculas buscarPeliculas(String nombre);
	
}
