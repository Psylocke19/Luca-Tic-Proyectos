package com.proyecto.spring;


import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto.spring.dao.IProvincia;
import com.proyecto.spring.model.Provincia;
import com.proyecto.spring.service.IServicios;


@RunWith(SpringRunner.class)
@SpringBootTest
public class addProvinciaTests {

	private static final Logger logger = LoggerFactory.getLogger(addProvinciaTests.class);
	@Autowired
	private IProvincia provincias;
	@Autowired
	private IServicios servicios;


	
	@Test
	public void addProvinciaTest() {
		logger.info("Añadiendo Provincia vacía.");
		int numProvInicial = provincias.findAll().size(); 
		logger.info("Inicial"+numProvInicial);
		Provincia p = new Provincia(100, "Borrame");
		servicios.addProvincia(p);
		int numProvFinal = provincias.findAll().size(); 
		logger.info("Final"+numProvFinal);
		assertTrue((numProvInicial+1)==numProvFinal);
	}
}