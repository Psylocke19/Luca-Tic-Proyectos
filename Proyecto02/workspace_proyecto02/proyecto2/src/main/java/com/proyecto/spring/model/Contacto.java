package com.proyecto.spring.model;

public class Contacto {

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
	
	
}
