package com.proyecto.spring.dao;

import org.springframework.stereotype.Repository;

import com.proyecto.spring.model.Persona;

@Repository
public interface IPersonaCustom{

	public Persona buscarPersona(Persona p);
}
