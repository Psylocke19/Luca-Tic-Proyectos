package modelo;

public class Peliculas {

	// ZONA PROPIEDADES
	private int idPeliculas;
	private String nombre;
	private String anio;
	private int num_categoria;

	// ZONA CONSTRUCTORES

	public Peliculas(int idPeliculas, String nombre, String anio, int num_categoria) {
		super();
		this.idPeliculas = idPeliculas;
		this.nombre = nombre;
		this.anio = anio;
		this.num_categoria = num_categoria;
	}
	// ZONA GETTERS Y SETTERS

	public int getIdPeliculas() {
		return idPeliculas;
	}

	public void setIdPeliculas(int idPeliculas) {
		this.idPeliculas = idPeliculas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public int getNum_categoria() {
		return num_categoria;
	}

	public void setNum_categoria(int num_categoria) {
		this.num_categoria = num_categoria;
	}

	// METODOS SOBREESCRITOS
	@Override
	public String toString() {
		return "Peliculas [idPeliculas=" + idPeliculas + ", nombre=" + nombre + ", anio=" + anio + ", num_categoria="
				+ num_categoria + "]";
	}

}
