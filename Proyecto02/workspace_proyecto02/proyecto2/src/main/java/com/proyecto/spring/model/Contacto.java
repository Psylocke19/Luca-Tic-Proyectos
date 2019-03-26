package com.proyecto.spring.model;

import java.util.ArrayList;

public class Contacto {

	private Persona persona;
	private ArrayList<Telefono> list_telefono = new ArrayList<Telefono>();
	private Telefono telefonofijo;
	private Telefono telefonomovil;
	private Direccion direccion;

	public Contacto(Persona persona, Telefono fijo, Telefono movil, Direccion direccion) {
		super();
		this.persona = persona;
		this.telefonofijo = fijo;
		this.telefonomovil = movil;
		this.direccion = direccion;

	}

	public Contacto(Persona persona, ArrayList<Telefono> list_telefono, Direccion direccion) {
		super();
		this.persona = persona;
		this.list_telefono = list_telefono;
		this.direccion = direccion;
	}

	public Contacto() {
		persona = new Persona();
		list_telefono = new ArrayList<Telefono>();
		direccion = new Direccion();
		telefonofijo = new Telefono();
		telefonomovil = new Telefono();
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public ArrayList<Telefono> getList_telefono() {
		return list_telefono;
	}

	public void setList_telefono(ArrayList<Telefono> list_telefono) {
		this.list_telefono = list_telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Telefono getTelefonofijo() {
		return telefonofijo;
	}

	public void setTelefonofijo(Telefono telefonofijo) {
		this.telefonofijo = telefonofijo;
	}

	public Telefono getTelefonomovil() {
		return telefonomovil;
	}

	public void setTelefonomovil(Telefono telefonomovil) {
		this.telefonomovil = telefonomovil;
	}

	@Override
	public String toString() {
		return "Contacto [persona=" + persona + ", list_telefono=" + list_telefono + ", direccion=" + direccion + "]";
	}

}
