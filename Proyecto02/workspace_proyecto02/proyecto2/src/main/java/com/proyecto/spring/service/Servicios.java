package com.proyecto.spring.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Provincia;
import com.proyecto.spring.dao.IDAOProvincias;

@Service
@Transactional
public class Servicios implements IServicios {

	@Autowired
	private IDAOProvincias datosprovincia;

	/**
	 * Con este método llamamos a la capa inmediatamente siguiente
	 * 
	 * @author Grupo 1
	 * @param p
	 */
	public void addProvincia(Provincia p) {
		datosprovincia.addProvincia(p);

	}

	/**
	 * Metodo que llama a la capa de Datos solicitando una lista de Provincias.
	 * 
	 * @return ArrayList<Provincia>
	 * @author Grupo 1
	 * 
	 * 
	 */
	public ArrayList<Provincia> mostrarProvincias() {

		return datosprovincia.mostrarProvincias();
	}

}
