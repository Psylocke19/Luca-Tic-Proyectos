package com.springrest.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.spring.model.Contacto;
import com.springrest.spring.model.Persona;
import com.springrest.spring.model.Provincia;


	@Repository
	@Transactional(readOnly = true)
	public class IProvinciaImpl implements IProvinciaCustom {

		@PersistenceContext
		EntityManager entityManager;


		/**
		 * Metodo que  lanza una query a la abse de datos y devuelve la informacion en base a un string de provincia dada
		 * 
		 * @author Grupo 1
		 * @param Persona p
		 * @return Persona p
		 * 
		 */
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public List buscarPorProvincia(String provincia) {
			System.out.println("------------------------ inside  IProvicniaImpl buscarporprovincia");

			Query query = entityManager.createNativeQuery(
					"SELECT * from telefono  join persona on telefono.idtelefono=persona.idpersona join direccion on persona.idpersona=direccion.iddireccion join provincia  on direccion.iddireccion = provincia.idprovincia where provincia= ?"
					, Provincia.class);
			
			query.setParameter(1, provincia);
			List l = query.getResultList();
			System.out.println("---------------------------- "+l);
			
			return  l;
		}
		
	
	
}
