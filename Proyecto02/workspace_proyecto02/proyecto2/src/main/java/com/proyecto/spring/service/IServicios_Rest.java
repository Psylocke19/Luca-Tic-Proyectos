package com.proyecto.spring.service;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.spring.model.Contacto;

public interface IServicios_Rest {

	public Contacto addContacto(Contacto c) ;
	public ArrayList<Contacto> mostrarContactos();
	public boolean borrarId(int idContacto) ;
<<<<<<< HEAD
	public Contacto editarContacto(Contacto c);
	public List buscarPorProvincia(String provincia) ;
=======
	/**public Contacto editarContacto(Contacto c);
	public Contacto BuscadorContacto(int id);
	*/
>>>>>>> 2b17dba0e627661ea165b9d3c5b381ec236e28d1
}
