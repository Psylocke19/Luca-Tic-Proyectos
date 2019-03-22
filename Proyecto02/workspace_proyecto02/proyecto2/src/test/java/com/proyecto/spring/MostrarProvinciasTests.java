package com.proyecto.spring;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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

@SpringBootTest
@RunWith(SpringRunner.class)
public class MostrarProvinciasTests {

	private static final Logger logger = LoggerFactory.getLogger(MostrarProvinciasTests.class);
	
	private ArrayList<Provincia> lista = new ArrayList<Provincia>();
	@Autowired
	private IServicios servicios;
	@Autowired
	private IProvincia datos;

	@Test
	public void comprobarRecogidaDatos() {
	
		long nRegistros = datos.count();
		int nDatos = servicios.mostrarProvincias().size();
		
		assertTrue(nRegistros == nDatos);
	}
	
	@Test
	public void comprobarDatosImpresos() {

		lista = servicios.mostrarProvincias();
		
		int nDatos = lista.size();
		
		int contador=0;
		
		for(Provincia p: lista) {
			contador++;
		}
		
		assertTrue(contador == nDatos);
	}
}
