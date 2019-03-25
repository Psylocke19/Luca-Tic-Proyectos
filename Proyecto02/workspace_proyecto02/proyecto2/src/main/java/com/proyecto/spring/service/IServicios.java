package com.proyecto.spring.service;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.spring.model.Contacto;
import com.proyecto.spring.model.Provincia;

public interface IServicios {

	public void addProvincia (Provincia p);
	public ArrayList<Provincia> mostrarProvincias();
	public void eliminarProvincias(int idProvincia);
	public void editarProvincia(Provincia p);
	public void addContacto(Contacto c);
	public List<Contacto> mostrarContactos(); 
}
