package com.proyecto.spring.control;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.spring.model.Contacto;

import com.proyecto.spring.service.IServicios;
import com.proyecto.spring.service.IServicios_Rest;

@RestController
@RequestMapping("/rest")
public class ControlRest {

	@Autowired
	private IServicios servicios;
	@Autowired
	private IServicios_Rest serviciosrest;

	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	
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
	public Contacto addContactoPost(@RequestBody Contacto c) throws Exception {
		
		// Le pasamos el objeto a la parte de servicios
		
		logger.info("en add contacto");
		return serviciosrest.addContacto(c);
	}

	/**
	 * Metodo que llama a la capa servicios y que devuelve un Objeto Contacto
	 * @param id
	 * @param Contacto c
	 * @return
	 
	@GetMapping("/editarContacto/{id}")
	public Contacto editarContacto(@PathVariable int id, Contacto c) {
		
		
		return servicios.editarContacto();
	
	
}
*/

}
