package com.proyecto.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.spring.model.Contacto;

import com.proyecto.spring.service.IServicios;

@RestController
@RequestMapping("/rest")
public class ControlRest {

	@Autowired
	private IServicios servicios;

	/**
	 * Metodo que retorna una lista de Contactos llamado de la capa servicios
	 * 
	 * @return
	 */
	@GetMapping("/mostrarContacto")
	public List<Contacto> mostrarContacto() {

		return servicios.mostrarContactos();

	}

	/**
	 * Metodo que retorna el objeto de tipo contacto llamando en servicios a addContacto y retornando el objeto Contacto recogido
	 * 
	 * @return
	 */
	@PostMapping("/addContacto")
	public Contacto addContactoPost(@ModelAttribute Contacto c) throws Exception {
		
		// Le pasamos el objeto a la parte de servicios
		servicios.addContacto(c);
		
		return c;
	}

	/**
	 * Metodo que llama a la capa servicios y que devuelve un Objeto Contacto
	 * @param id
	 * @param Contacto c
	 * @return
	 
	@GetMapping("/editarContacto/{id}")
	public Contacto editarContacto(@PathVariable int id, Contacto c) {
		
		
		return servicios.editarContacto();
	
	
}*/


}
