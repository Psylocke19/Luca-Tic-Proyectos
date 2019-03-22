package com.proyecto.spring.model;

public class Contacto {

<<<<<<< HEAD
	private Persona p;
	private Telefono tl;
	private Direccion dir;
	private Provincia pro;
	
	
	public Contacto(Persona p, Telefono tl, Direccion dir, Provincia pro) {
		super();
		this.p = p;
		this.tl = tl;
		this.dir = dir;
		this.pro = pro;
	}
	public Contacto() {
		// TODO Auto-generated constructor stub
	}
	public Persona getP() {
		return p;
	}
	public void setP(Persona p) {
		this.p = p;
	}
	public Telefono getTl() {
		return tl;
	}
	public void setTl(Telefono tl) {
		this.tl = tl;
	}
	public Direccion getDir() {
		return dir;
	}
	public void setDir(Direccion dir) {
		this.dir = dir;
	}
	public Provincia getPro() {
		return pro;
	}
	public void setPro(Provincia pro) {
		this.pro = pro;
	}
=======
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

>>>>>>> e9c6cb3aca25b3b0708b864ffd08512e70408d71
	
	
}
