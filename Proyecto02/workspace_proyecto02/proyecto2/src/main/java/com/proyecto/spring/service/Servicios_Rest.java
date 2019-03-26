package com.proyecto.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.dao.IDireccion;
import com.proyecto.spring.dao.IPersona;
import com.proyecto.spring.dao.IProvincia;
import com.proyecto.spring.dao.ITelefono;
import com.proyecto.spring.model.Contacto;
import com.proyecto.spring.model.Direccion;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.model.Telefono;

@Service
@Transactional
public class Servicios_Rest implements IServicios_Rest{

	@Autowired
	private IProvincia restDatosprovincia;

	@Autowired
	private IPersona restDatospersona;

	@Autowired
	private IDireccion restDatosdireccion;

	@Autowired
	private ITelefono restDatostelefono;
	
	
	public Contacto addContacto(Contacto c) {

		// Annadimos el Objeto Persona a la BBDD
		Persona personaRest =restDatospersona.save(c.getPersona());

		// Buscamos la persona que hemos annadido y con el metodo
		// buscarPersona(Implementado por nosotros) nos
		// devuelve ese mismo objeto completo, con la ID generada por la BBDD
		Persona miPersona = restDatospersona.buscarPersona(c.getPersona());

		
		// Le annadimos al telefono de contacto el objeto Persona completo con el ID
		for (int i = 0; i < c.getList_telefono().size(); i++) {
			c.getList_telefono().get(i).setPersona(miPersona);

			// Annadimos ahora el objeto telefono entero con la Persona ya relaccionada
			 restDatostelefono.save(c.getList_telefono().get(i));
		}

		// Hacemos lo mismo con el objeto Direccion
		c.getDireccion().setPersona(miPersona);

		// La annadimos a la BBDD
		Direccion dir=restDatosdireccion.save(c.getDireccion());
		//creamos el objeto y le metemos las propiedades
		Contacto con = new Contacto();
		con.setDireccion(dir);
		con.setPersona(personaRest);
		con.setList_telefono(c.getList_telefono());
		
		return con;

}
}