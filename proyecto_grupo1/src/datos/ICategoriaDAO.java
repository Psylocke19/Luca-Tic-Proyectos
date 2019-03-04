package datos;

import modelo.Categoria;

public interface ICategoriaDAO {
	public void addCategoria(Categoria c); 
	public Categoria buscarCategoria(String nombreCategoria); 
	public boolean comprobacionCategoriaDuplicada(String nombreCategoria); 

}
