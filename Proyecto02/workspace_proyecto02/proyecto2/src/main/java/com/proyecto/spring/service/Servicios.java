package com.proyecto.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.proyecto.spring.dao.IDireccion;
import com.proyecto.spring.dao.IPersona;
import com.proyecto.spring.dao.IProvincia;

import com.proyecto.spring.dao.ITelefono;

import com.proyecto.spring.model.Contacto;
import com.proyecto.spring.model.Direccion;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.model.Provincia;
import com.proyecto.spring.model.Telefono;

@Service
@Transactional
public class Servicios implements IServicios {

	@Autowired
	private IProvincia datosprovincia;

	@Autowired
	private IPersona datospersona;

	@Autowired
	private IDireccion datosdireccion;

	@Autowired
	private ITelefono datostelefono;

	/**
	 * Con este método llamamos a la capa inmediatamente siguiente y lo añade a la
	 * base de datos de objetos mediante los metodos de jpa
	 * 
	 * @author Grupo 1
	 * @param p
	 */
	public void addProvincia(Provincia p) {
		datosprovincia.save(p);
	}

	/**
	 * Metodo que llama a la capa de Datos solicitando una lista de Provincias y
	 * retorna una lista mediante metodos de jpa
	 * 
	 * @return ArrayList<Provincia>
	 * @author Grupo 1
	 * 
	 * 
	 */
	public ArrayList<Provincia> mostrarProvincias() {

		return (ArrayList<Provincia>) datosprovincia.findAll();
	}

	/**
	 * Metodo que pasa por parametro un id de provincias y elimina la provincia de
	 * la base de datos
	 * 
	 * @return void
	 * @author Grupo 1
	 * 
	 * 
	 */
	public void eliminarProvincias(int idProvincia) {

		datosprovincia.deleteById(idProvincia);
	}

	/**
	 * Metodo que le entra un un objeto de tipo Provincia y lo envia al apartado de
	 * datos.
	 * 
	 * @param Provincia p
	 * @return void
	 * @author Grupo 1
	 * 
	 * 
	 */
	public void editarProvincia(Provincia p) {
		// TODO Auto-generated method stub
		datosprovincia.save(p);
	}

	/**
	 * Metodo para desencapsular el objeto contacto y meter los atributos a la base
	 * de datos
	 * 
	 * @param Provincia p
	 * @return void
	 * @author Grupo 1
	 * 
	 * 
	 */

	public void addContacto(Contacto c) {

		// Annadimos el Objeto Persona a la BBDD
		datospersona.save(c.getPersona());

		// Buscamos la persona que hemos annadido y con el metodo
		// buscarPersona(Implementado por nosotros) nos
		// devuelve ese mismo objeto completo, con la ID generada por la BBDD
		Persona miPersona = datospersona.buscarPersona(c.getPersona());

		// Le annadimos al telefono de contacto el objeto Persona completo con el ID
		for (int i = 0; i < c.getList_telefono().size(); i++) {
			c.getList_telefono().get(i).setPersona(miPersona);

			// Annadimos ahora el objeto telefono entero con la Persona ya relaccionada
			datostelefono.save(c.getList_telefono().get(i));
		}

		// Hacemos lo mismo con el objeto Direccion
		c.getDireccion().setPersona(miPersona);

		// La annadimos a la BBDD
		datosdireccion.save(c.getDireccion());

	}

	public List<Contacto> mostrarContactos() {

		List<Persona> persona = datospersona.findAll();
		List<Telefono> telefono = datostelefono.findAll();
		List<Direccion> direccion = datosdireccion.findAll();

		ArrayList<Contacto> listaContactos = new ArrayList<>();
		for (Persona p : persona) {
			Contacto c = new Contacto();
			c.setPersona(p);

			ArrayList<Telefono> listaTelefonos = new ArrayList<>();
			for (Telefono t : telefono) {
				if (t.getPersona().getIdpersona() == p.getIdpersona()) {
					listaTelefonos.add(t);
				}
			}
			c.setList_telefono(listaTelefonos);
			for (Direccion d : direccion) {
				if (d.getPersona().getIdpersona() == p.getIdpersona()) {
					c.setDireccion(d);
				}
			}
			listaContactos.add(c);
		}
		return listaContactos;
	}

}
