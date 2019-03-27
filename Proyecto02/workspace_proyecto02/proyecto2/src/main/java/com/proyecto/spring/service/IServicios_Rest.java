package com.proyecto.spring.service;

import java.util.ArrayList;

import com.proyecto.spring.model.Contacto;

public interface IServicios_Rest {

	public Contacto addContacto(Contacto c) ;
	public ArrayList<Contacto> mostrarContactos();
	public boolean borrarId(int idContacto) ;
	/**public Contacto editarContacto(Contacto c);
	public Contacto BuscadorContacto(int id);
	*/
}
