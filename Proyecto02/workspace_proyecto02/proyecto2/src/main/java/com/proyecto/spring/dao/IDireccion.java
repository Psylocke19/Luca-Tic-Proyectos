package com.proyecto.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.model.Direccion;


@Repository
public interface IDireccion  extends JpaRepository<Direccion, Integer>  {
	/*
	void delete(User user);

	List<User> findAll();

	User findOne(int id);

	User save(User user);*/
}
