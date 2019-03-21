package com.proyecto.spring.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.proyecto.model.Provincia;

@Repository
public class DAOProvincias implements IDAOProvincias {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * Metodo que recibe una provincia por parametro y lo añade a la base de datos
	 * 
	 * @author grupo 1
	 * @param p
	 * 
	 * 
	 */

	public void addProvincia(Provincia p) {
		em.persist(p);
		em.flush();
	}

	/**
	 * Metodo que envia una consulta a la base de datos para sacar todas las
	 * provincias de la tabla Provincia y las devuelve en un ArrayList
	 * 
	 * @author Grupo 1
	 * @return ArrayList<Provincia>
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Provincia> mostrarProvincias() {

		return (ArrayList<Provincia>) em.createQuery("from Provincia").getResultList();

	}
}
