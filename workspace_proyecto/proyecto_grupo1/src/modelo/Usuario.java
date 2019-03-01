package modelo;

public class Usuario {

	//ATRIBUTOS 
	private int idUsuario;
	private String nombre_completo;
	private String fecha;
	private String ciudad_residencia;
	//private Integer paquete_abonado;
	
	//FIN DE ZONA ATRIBUTOS
	//ZONA CONSTRUCTORES
	
	public Usuario(int idUsuario,String nombre_completo, String fecha, String ciudad_residencia) {
		super();
		this.idUsuario = idUsuario;
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

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	//FIN METODOS GETTER AND SETTER

	
	//METODO TOSTRING
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre_completo=" + nombre_completo + ", fecha=" + fecha
				+ ", ciudad_residencia=" + ciudad_residencia + "]";
	}
	
	
	
}
