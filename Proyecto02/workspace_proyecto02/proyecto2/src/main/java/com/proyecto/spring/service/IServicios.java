package com.proyecto.spring.service;

import java.util.ArrayList;

import com.proyecto.model.Provincia;

public interface IServicios {

	public void addProvincia (Provincia p);
	public ArrayList<Provincia> mostrarProvincias();
	
}
