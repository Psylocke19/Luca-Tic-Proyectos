package com.proyecto.spring.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;

import com.proyecto.spring.model.Persona;

@Repository
@Transactional(readOnly = true)
public class IPersonaImpl implements IPersonaCustom {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Metodo que busca una persona por parametros y nos devuelve el objeto completo
	 * con la id que le asigno la base de datos
	 * 
	 * @author Grupo 1
	 * @param Persona p
	 * @return Persona p
	 * 
	 */

	// Este metodo lo creamos para buscar el objeto que introducimos en el apartado
	// de servicios y luego para averiguar la ID que le genero la BBDD, lo buscamos
	// con los datos, y nos retorna el objeto completo con el ID generado

	@Override
	public Persona buscarPersona(Persona p) {

		Query query = entityManager.createNativeQuery(
				"FROM Persona WHERE nombre=?, apellido1=?, apellido2=?,dni=?,fechanacimiento=?", Persona.class);
		query.setParameter(1, p.getNombre());
		query.setParameter(2, p.getApellido1());
		query.setParameter(3, p.getApellido2());
		query.setParameter(4, p.getDni());
		query.setParameter(5, p.getFechanacimiento());

		return (Persona) query.getSingleResult();
	}

}
