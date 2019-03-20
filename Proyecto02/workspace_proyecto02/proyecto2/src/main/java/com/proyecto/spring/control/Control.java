package com.proyecto.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proyecto.model.Provincia;
import com.proyecto.spring.service.Servicios;

@Controller
public class Control {

	@Autowired
	Servicios service;
	
	private static final Logger logger = LoggerFactory.getLogger(Control.class);
	
	/**
	 * Metodo que recoge una provincia a traves de metodo POST y la baja a la capa de Servicios.
	 * @author Grupo 1
	 * @param Provincia p
	 * @return ModelAndView
	 * @throws Exception
	 */
	@PostMapping("/addProvincia")
	public ModelAndView addProvincia(@ModelAttribute Provincia p) throws Exception {
		logger.info("-- en annadir Provincia");		
		//Le pasamos el objeto a la parte de servicios 
		service.addProvincia(p);
		//Una vez se haya annadido nos redirigimos a la pagina inicial de provincias
		ModelAndView model = new ModelAndView("redirect:/");

		return model;
	}
	
}
