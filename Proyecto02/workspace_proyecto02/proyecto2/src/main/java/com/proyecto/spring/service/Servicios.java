package com.proyecto.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Provincia;
import com.proyecto.spring.dao.DAOProvincias;

@Service
@Transactional
public class Servicios implements IServicios {
	
	@Autowired
	private DAOProvincias datosprovincia; 
	
	/**
	 * Con este método llamamos a la capa inmediatamente siguiente
	 * @author Grupo 1
	 * @param p
	 */
	public void addProvincia (Provincia p) {
		datosprovincia.addProvincia(p); 
		
	}

}
