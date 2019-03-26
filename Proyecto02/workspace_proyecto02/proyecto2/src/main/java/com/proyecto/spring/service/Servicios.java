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
		c.getTelefonofijo().setPersona(miPersona);

		c.getTelefonomovil().setPersona(miPersona);
		
		//Antes de annadir cualquiera de los dos, comprobamos si no estan vacios, en caso de que esten, no se annadira
		if(!c.getTelefonofijo().getTelefono().isEmpty()) {
			datostelefono.save(c.getTelefonofijo());
		}
		if(!c.getTelefonomovil().getTelefono().isEmpty()) {
			datostelefono.save(c.getTelefonomovil());
		}
		
		// Hacemos lo mismo con el objeto Direccion
		c.getDireccion().setPersona(miPersona);

		System.out.println(c.getDireccion().getProvincia().toString());
		
		//c.getDireccion().setProvincia(new Provincia(1, ""));
		
		// La annadimos a la BBDD
		datosdireccion.save(c.getDireccion());

	}

	/**
	 * Metodo para mostrar la lista de contactos a partir de las listas de persona,
	 * telefono y direccion
	 * 
	 * @return List<Contacto>
	 * @author Grupo 1
	 * 
	 * 
	 */
	public ArrayList<Contacto> mostrarContactos() {

		// Creamos una lista para persona, telefono y direccion a partir de la base de
		// datos correspondiente
		List<Persona> persona = datospersona.findAll();
		List<Telefono> telefono = datostelefono.findAll();
		List<Direccion> direccion = datosdireccion.findAll();

		// Creamos un ArrayList de contactos donde almacenaremos los datos de las
		// distintas tablas
		ArrayList<Contacto> listaContactos = new ArrayList<>();
		// Recorremos el array rellenándolo con los datos de las personas
		for (Persona p : persona) {
			Contacto c = new Contacto();
			c.setPersona(p);

			// Hacemos lo mismo con la de teléfonos pero en forma de ArrayList, ya que cada
			// persona puede tener asociado más de un teléfono
			ArrayList<Telefono> listaTelefonos = new ArrayList<>();
			for (Telefono t : telefono) {
				if (t.getPersona().getIdpersona() == p.getIdpersona()) {
					listaTelefonos.add(t);
				}
			}
			c.setList_telefono(listaTelefonos);
			// Introducimos las direcciones
			for (Direccion d : direccion) {
				if (d.getPersona().getIdpersona() == p.getIdpersona()) {
					c.setDireccion(d);
				}
			}
			listaContactos.add(c);
		}
		// Devolvemos la lista de contactos ya cohesionada
		return listaContactos;
	}

	/**
	 * Metodo que introduce un objeto de tipo contacto y es eliminada su
	 * encapsulacion partiendo el objeto en persona direccion y la lista de
	 * telefonos
	 * @author grupo1
	 * @param Contacto
	 */
	public void editarContacto(Contacto c) {

		datospersona.save(c.getPersona());
		datosdireccion.save(c.getDireccion());
		datostelefono.saveAll(c.getList_telefono());

	}

	/**
	 * Metodo que elimina un contacto de la BBDD. Le pasamos el ID de la Persona, y
	 * una vez borramos esta, automaticamente se borra tanto las direcciones como
	 * los telefonos asociados a esa persona
	 * 
	 * @author Grupo 1
	 * @param int idContacto
	 */

	public void eliminarContacto(int idContacto) {

		// Eliminamos solo la persona porque en la BBDD esta puesto el DELETE ON
		// CASCADE, y todas las direcciones y telefono asociados al ID de esa persona,
		// seran eliminados una vez que la persona se elimine
		datospersona.deleteById(idContacto);
	}

}
