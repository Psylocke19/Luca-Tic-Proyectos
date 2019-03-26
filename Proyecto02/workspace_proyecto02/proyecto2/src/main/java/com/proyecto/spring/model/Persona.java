package com.proyecto.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpersona;

	private String apellido1;

	private String apellido2;

	private String dni;

	@Column(name = "fechanacimiento")
	private String fechanacimiento;

	private String nombre;

	public Persona(int idpersona, String apellido1, String apellido2, String dni, String fechanacimiento,
			String nombre) {
		super();
		this.idpersona = idpersona;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
		this.nombre = nombre;
	}

	public Persona() {
	}

	public int getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [idpersona=" + idpersona + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni="
				+ dni + ", fechanacimiento=" + fechanacimiento + ", nombre=" + nombre + "]";
	}

}