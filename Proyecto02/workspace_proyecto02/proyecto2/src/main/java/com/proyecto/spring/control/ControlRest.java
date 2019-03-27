package com.proyecto.spring.control;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.spring.model.Contacto;

import com.proyecto.spring.service.IServicios_Rest;

@RestController
@RequestMapping("/rest")
public class ControlRest {

	@Autowired
	private IServicios_Rest serviciosRest;

	private static final Logger logger = LogManager.getLogger("Mensaje :");

	/**
	 * Metodo que retorna una lista de Contactos llamado de la capa servicios
	 * 
	 * @return
	 */
	@GetMapping("/mostrarContacto")
	public List<Contacto> mostrarContacto() {

		return serviciosRest.mostrarContactos();

	}

	/**
	 * Metodo que retorna el objeto de tipo contacto llamando en servicios a
	 * addContacto y retornando el objeto Contacto recogido
	 * 
	 * @return
	 */
	@PostMapping("/addContacto")
	public Contacto addContactoPost(@RequestBody Contacto c) throws Exception {

		// Le pasamos el objeto a la parte de servicios

		logger.info("en add contacto");
		return serviciosRest.addContacto(c);
	}

	/**
	 * 
	 * Metodo que elimina llama mediante la interfaz de serviciosrest a borrarid de
	 * la capa servicios pasandole un id,usando la anotacion deletemapping,si
	 * devuelve un false es que no existe el objeto y por tanto ha sido borrado
	 * 
	 * @author Grupo 1
	 * @param id
	 * @return boolean
	 * @throws Exception
	 */

	@DeleteMapping("/eliminarContacto/{id}")
	public boolean eliminarContacto(@PathVariable int id) throws Exception {
		logger.info("-- en eliminar Contacto");
		// Le pasamos el id a la parte de servicios
		return serviciosRest.borrarId(id);
	}

	
	/**
	 * Metodo que llama a editarContacto y recoge el objeto con los datos y lo envía
	 * @param id
	 * @return
	
	@GetMapping(path= "/editarContacto/{id}")
	public Contacto editarContacto(@PathVariable int id ) {
		
		return serviciosRest.BuscadorContacto(id);
	}
		 
	
	
	
	/**
	 * Metodo que retorna un Objeto Contacto modificado desde la capa de Servicios
	 * @param Contacto c
	 * @return
	 
	
	 
<<<<<<< HEAD
	@PutMapping("/editarContacto/{id}")
	public Contacto editarContacto(@PathVariable Contacto c) {
				
		return serviciosRest.editarContacto(c);
	
	
}
	@GetMapping("/muestraProvincia/{provincia}")
	public List buscarPorProvincia(@PathVariable String provincia) {
		System.out.println("------------------ inside controlle r buscarPorProvincia: "+provincia);
		
		return serviciosRest.buscarPorProvincia(provincia);
		
	}

=======
	@PutMapping(path= "/editarContacto/{id}")
	public Contacto editarContactoBuscado(@RequestBody Contacto contacto ) {
		
		return serviciosRest.editarContacto(contacto);
	
	
}*/
>>>>>>> 2b17dba0e627661ea165b9d3c5b381ec236e28d1


}
