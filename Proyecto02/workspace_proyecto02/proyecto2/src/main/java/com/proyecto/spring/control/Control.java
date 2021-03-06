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

import com.proyecto.spring.model.Contacto;
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
		model.addObject("value", "add");
		model.addObject("claveProvincia", new Provincia());
		return model;

	}

	@GetMapping("/editProvincia/{id}")
	public ModelAndView mostrareditdProvincias(@PathVariable int id) throws Exception {
		logger.info("-- Mostrando editarProvincia");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("addProvincias");
		model.addObject("value", "edit");
		Provincia p = new Provincia();
		p.setId(id);
		p.setNombre("");
		model.addObject("claveProvincia", p);
		logger.info("-- Saliendo editarProvincia");

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
	@PostMapping("/editProvincia/{id}")
	public ModelAndView editarProvincia(@ModelAttribute Provincia p) throws Exception {
		logger.info("-- en editar Provincias");
		// Le pasamos el objeto a la parte de servicios
		service.editarProvincia(p);

		logger.info("-- Provincia editada");

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
	public ModelAndView addContacto() throws Exception {
		logger.info("-- addContacto");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("addContacto");
		model.addObject("value", "add");
		model.addObject("claveContacto", new Contacto());
		model.addObject("claveProvincias", service.mostrarProvincias());
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
	public ModelAndView addContactoPost(@ModelAttribute Contacto c) throws Exception {
		logger.info("-- en annadir Contacto");
		// Le pasamos el objeto a la parte de servicios
		service.addContacto(c);
		logger.info("-- Contacto annadido a la BD");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("redirect:/listaContactos");

		return model;
	}

	@GetMapping("/listaContactos")
	public ModelAndView mostrarContactos() throws Exception {
		logger.info("-- en lista Contactos");
		// Le pasamos el objeto a la parte de servicios
		ArrayList<Contacto> listaContactos = service.mostrarContactos();
		logger.info("-- Lista rellenada");
		// Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("ListaContactos");
		model.addObject("claveListaContactos", listaContactos);

		return model;

	}

	/**
	 * 
	 * @author Grupo 1
	 * @param id
	 * @return model
	 * @throws Exception
	 */

	@GetMapping("/eliminarContacto/{id}")
	public ModelAndView eliminarContacto(@PathVariable int id) throws Exception {
		logger.info("-- en eliminar Contacto");
		// Le pasamos el objeto a la parte de servicios
		service.eliminarContacto(id);
		logger.info("-- Contacto eliminado de la BD");
		// Una vez se haya eliminado el contacto nos redigirimos a listarContactos
		ModelAndView model = new ModelAndView("redirect:/listaContactos");

		return model;
	}

	/**
	 * Método que busca un contacto por su id y retorna el objeto correspondiente
	 * con sus datos
	 * 
	 * @author Grupo 1
	 * @param Contacto c
	 * @return ModelAndView
	 * @throws Exception
	 */

	@GetMapping("/editarContacto/{id}")
	public ModelAndView editarContacto(@PathVariable int id) throws Exception {
		logger.info("-- en mostrar Editar Contacto");
		ModelAndView model = new ModelAndView("addContacto");
		model.addObject("value", "edit");
		model.addObject("claveContacto", service.buscadorContacto(id));
		logger.info(service.buscadorContacto(id).toString());
		model.addObject("claveProvincias", service.mostrarProvincias());

		return model;
	}

	/**
	 * Metodo que recoge un objeto con los datos modificados y los actualiza en la
	 * BBDD
	 * 
	 * @param Contacto
	 * @author Grupo 1
	 * @throws Exception
	 */

	@PostMapping("/editarContacto/{id}")
	public ModelAndView editarContacto(@ModelAttribute Contacto c) throws Exception {
		logger.info("-- en editar Contactos");
		// Le pasamos el objeto a la parte de servicios
		logger.info(c.toString());
		service.editarContacto(c);

		logger.info("-- Contacto editado");

		// Una vez se haya annadido nos redirigimos a la pagina inicial de contactos
		ModelAndView model = new ModelAndView("redirect:/listaContactos");

		return model;
	}

}
