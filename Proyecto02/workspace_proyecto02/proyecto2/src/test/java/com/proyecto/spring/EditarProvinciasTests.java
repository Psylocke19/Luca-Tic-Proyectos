package com.proyecto.spring;

import static org.junit.Assert.assertTrue;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto.spring.dao.IProvincia;

import com.proyecto.spring.model.Provincia;
import com.proyecto.spring.service.IServicios;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EditarProvinciasTests {

	@Autowired
	private IServicios servicios;
	@Autowired
	private IProvincia datos;
	
	@Test
	public void comprobarEditarProvinciasTest1() {
		
		
		servicios.addProvincia(new Provincia(0,"prueba1"));
		servicios.editarProvincia(new Provincia(59,"prueba2"));
		
		assertTrue(datos.findById(59).get().getNombre().equals("prueba2"));
	}
		
		
	}
	
