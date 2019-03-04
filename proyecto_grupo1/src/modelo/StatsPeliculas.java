package modelo;

public class StatsPeliculas {

	private int idStatsPeliculas;
	private int idPeliculas;
	private int idUsuario;
	
	public StatsPeliculas() {
		super();
	}

	public StatsPeliculas(int idStatsPeliculas, int idPeliculas, int idUsuario) {
		super();
		this.idStatsPeliculas = idStatsPeliculas;
		this.idPeliculas = idPeliculas;
		this.idUsuario = idUsuario;
	}

	public int getIdStatsPeliculas() {
		return idStatsPeliculas;
	}

	public void setIdStatsPeliculas(int idStatsPeliculas) {
		this.idStatsPeliculas = idStatsPeliculas;
	}

	public int getIdPeliculas() {
		return idPeliculas;
	}

	public void setIdPeliculas(int idPeliculas) {
		this.idPeliculas = idPeliculas;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "StatsPeliculas [idStatsPeliculas=" + idStatsPeliculas + ", idPeliculas=" + idPeliculas + ", idUsuario="
				+ idUsuario + "]";
	}
	
	
}
