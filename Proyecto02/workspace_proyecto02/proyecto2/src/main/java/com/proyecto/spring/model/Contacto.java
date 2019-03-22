package com.proyecto.spring.model;

public class Contacto {

	private Persona persona;
	private Telefono telefono;
	private Direccion direccion;

	

	public Contacto(Persona persona, Telefono telefono, Direccion direccion) {
		super();
		this.persona = persona;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Contacto [persona=" + persona + ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}

	
	
}
