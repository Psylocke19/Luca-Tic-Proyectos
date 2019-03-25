package com.proyecto.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.model.Contacto;
import com.proyecto.spring.service.IServicios;

@RestController
@RequestMapping("/rest")
public class ControlRest {

	@Autowired
	private IServicios servicios;
	
	@GetMapping("/mostrarContacto")
	public List<Contacto> mostrarContacto(){
		
		
		return servicios.mostrarContactos();
		
		
	}
	

}
