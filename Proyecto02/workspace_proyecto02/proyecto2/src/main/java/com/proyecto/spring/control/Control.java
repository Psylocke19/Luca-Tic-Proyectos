package com.proyecto.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proyecto.spring.model.Provincia;
import com.proyecto.spring.service.IServicios;

import antlr.collections.List;

@Controller
public class Control {

	@Autowired
	IServicios service;

	private static final Logger logger = LoggerFactory.getLogger(Control.class);

	/**
	 * 
	 * @author Grupo 1
	 * @param p
	 * @return Model
	 * @throws Exception
	 */

	@GetMapping("/listaProvincias")
	public ModelAndView mostrarProvincias() throws Exception {
		logger.info("-- en lista Provincias");
		// Le pasamos el objeto a la parte de servicios
		ArrayList<Provincia> listaProvincias = service.mostrarProvincias();
		logger.info("-- Lista rellenada");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("ListarProvincial");
		model.addObject("claveListaProvincias", listaProvincias);

		return model;

	}

	/**
	 * 
	 * @author Grupo 1
	 * @param p
	 * @return ModelAndView
	 * @throws Exception
	 */

	@GetMapping("/addProvincia")
	public ModelAndView mostraraddProvincias() throws Exception {
		logger.info("-- addPtro");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("addProvincias");
		model.addObject("claveProvincia", new Provincia());
		return model;

	}

	/**
	 * Metodo que recoge una provincia a traves de metodo POST y la baja a la capa
	 * de Servicios.
	 * 
	 * @author Grupo 1
	 * @param Provincia p
	 * @return ModelAndView
	 * @throws Exception
	 */
	@PostMapping("/addProvincia")
	public ModelAndView addProvincia(@ModelAttribute Provincia provincia) throws Exception {
		logger.info("-- en annadir Provincia");
		// Le pasamos el objeto a la parte de servicios
		service.addProvincia(provincia);
		logger.info("-- Provincia annadida a la BD");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("redirect:/listaProvincias");

		return model;
	}

	/**
	 * 
	 * @author Grupo 1
	 * @param id
	 * @return model
	 * @throws Exception
	 */

	@GetMapping("/eliminarProvincias/{id}")
	public ModelAndView eliminarProvincias(@PathVariable int id) throws Exception {
		logger.info("-- en eliminar Provincias");
		// Le pasamos el objeto a la parte de servicios
		service.eliminarProvincias(id);
		logger.info("-- Provincia eliminada de la BD");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("redirect:/listaProvincias");

		return model;
	}

	/**
	 * 
	 * 
	 * 
	 * @author Grupo 1
	 * @param id
	 * @return model
	 * @throws Exception
	 */
	@GetMapping("/editarProvincias")
	public ModelAndView editarProvincia(@ModelAttribute Provincia p) throws Exception {
		logger.info("-- en editar Provincias");
		// Le pasamos el objeto a la parte de servicios
		logger.info("-- Provincia editada");
		service.editarProvincia(p);
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("redirect:/listaProvincias");

		return model;
	}

	/**
	 * 
	 * Mapea a addContacto mediante un metodo GET y se le pasa un objeto de tipo
	 * Contacto enviando una pagina "addContacto" y añado un atributo
	 * llamado"claveContacto" con un objeto nuevo de Contacto
	 * 
	 * @author Grupo 1
	 * @param Contacto c
	 * @return ModelAndView
	 * @throws Exception
	 */

	@GetMapping("/addContacto")
	public ModelAndView addContacto(Contacto c) throws Exception {
		logger.info("-- addPtro");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("addContacto");
		model.addObject("claveContacto", new Contacto());
		return model;

	}

	/**
	 * Mapea a addContacto mediante un metodo POST y se le pasa un objeto de tipo
	 * Contacto con atributos rellenos redireccionando a listaProvincias
	 * 
	 * @author Grupo 1
	 * @param Provincia p
	 * @return ModelAndView
	 * @throws Exception
	 */
	@PostMapping("/addContacto")
	public ModelAndView addProvincia(@ModelAttribute Contacto c) throws Exception {
		logger.info("-- en annadir Provincia");
		// Le pasamos el objeto a la parte de servicios
		service.addContacto(c);
		logger.info("-- Provincia annadida a la BD");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("redirect:/listaProvincias");

		return model;
	}
}
