package modelo;

public class Usuario {

	//ATRIBUTOS 
	private String nombre_completo;
	private String fecha;
	private String ciudad_residencia;
	//private Integer paquete_abonado;
	
	//FIN DE ZONA ATRIBUTOS
	//ZONA CONSTRUCTORES
	
	public Usuario(String nombre_completo, String fecha, String ciudad_residencia) {
		super();
		this.nombre_completo = nombre_completo;
		this.fecha = fecha;
		this.ciudad_residencia = ciudad_residencia;
	}
	
	//FIN ZONA CONSTRUTORES
	
	
	//METODOS GETTERS Y SETTERS
	public String getNombre_completo() {
		return nombre_completo;
	}
	
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCiudad_residencia() {
		return ciudad_residencia;
	}
	public void setCiudad_residencia(String ciudad_residencia) {
		this.ciudad_residencia = ciudad_residencia;
	}
	
	//FIN DE METODOS GETTERS Y SETTERS
	
	
}
