package com.proyecto.spring.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.dao.IProvincia;
import com.proyecto.spring.model.Provincia;

@Service
@Transactional
public class Servicios implements IServicios {

	@Autowired
	private IProvincia datosprovincia;

	/**
	 * Con este método llamamos a la capa inmediatamente siguiente y lo añade a la
	 * base de datos de objetos mediante los metodos de jpa
	 * 
	 * @author Grupo 1
	 * @param p
	 */
	public void addProvincia(Provincia p) {
		datosprovincia.save(p);
	}

	/**
	 * Metodo que llama a la capa de Datos solicitando una lista de Provincias y 
	 * retorna una lista mediante metodos de jpa
	 * 
	 * @return ArrayList<Provincia>
	 * @author Grupo 1
	 * 
	 * 
	 */
	public ArrayList<Provincia> mostrarProvincias() {

		return (ArrayList<Provincia>) datosprovincia.findAll();
	}

	/**
	 * Metodo que pasa por parametro un id de provincias y elimina la provincia de la base de datos
	 * 
	 * @return void
	 * @author Grupo 1
	 * 
	 * 
	 */
	public void eliminarProvincias(int idProvincia) {
		
		datosprovincia.deleteById(idProvincia);
	}
}
