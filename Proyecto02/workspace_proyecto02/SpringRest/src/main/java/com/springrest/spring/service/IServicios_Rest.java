package com.springrest.spring.service;

import java.util.ArrayList;
import java.util.List;

import com.springrest.spring.model.Contacto;

public interface IServicios_Rest {

	public Contacto addContacto(Contacto c) ;
	public ArrayList<Contacto> mostrarContactos();
	public boolean borrarId(int idContacto) ;
	//public Contacto editarContacto(Contacto c);
	public List buscarPorProvincia(String provincia) ;

	/**public Contacto editarContacto(Contacto c);
	public Contacto BuscadorContacto(int id);
	*/

}
