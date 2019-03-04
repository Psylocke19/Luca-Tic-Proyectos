package datos;

import modelo.Peliculas;

public interface IPeliculasDAO {
	public void addPeliculas(Peliculas pelicula);
	public void modificarPeliculas(Peliculas pelicula);
    public void eliminarPeliculas(Peliculas pelicula);
    public void listarPeliculas();
    public void listarPorMasVistas();
    public void listarPorMasValoradas();
    public boolean comprobacionPeliculaDuplicada(String nombre,String anio);
    public Peliculas buscarPeliculas(String nombre);
	
}
