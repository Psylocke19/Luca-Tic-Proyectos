package com.proyecto.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.proyecto.spring.control.Control;
import com.proyecto.spring.dao.IProvincia;
import com.proyecto.spring.service.IServicios;

@SpringBootTest
@RunWith(SpringRunner.class)

public class EliminarProvinciaTest {
	
	private static final Logger logger = LoggerFactory.getLogger(EliminarProvinciaTest.class);
	
	@Autowired
	private IServicios servicios;
	
	@Test
	public void eliminarDatos() {
		int cantidadInicial;
		int cantidadFinal; 
	
			//En primer lugar miramos cuántos elementos hay en la tabla
			cantidadInicial = servicios.mostrarProvincias().size(); 
			logger.info("El número de películas iniciales es de: " + cantidadInicial);
			// A continuación borramos uno de ellos con el método eliminar
			servicios.eliminarProvincias(1);
			// Comprobamos que hay uno menos
			cantidadFinal = servicios.mostrarProvincias().size(); 
			logger.info("El número de películas final es de: " + cantidadFinal);
			// Comprobamos que no existe ese elemento
			assertEquals(cantidadInicial, cantidadFinal + 1);
		}

}


	
