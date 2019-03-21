package com.proyecto.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.model.Provincia;

@Repository
public interface IProvincia extends JpaRepository<Provincia, Integer> {

	/*
	void delete(User user);

	List<User> findAll();

	User findOne(int id);

	User save(User user);*/
}