package com.proyecto.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.proyecto.spring.dao.IDireccion;
import com.proyecto.spring.dao.IPersona;
import com.proyecto.spring.dao.IProvincia;
import com.proyecto.spring.dao.IProvinciaCustom;
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
		List<Persona> persona = restDatospersona.findAll();
		List<Telefono> telefono = restDatostelefono.findAll();
		List<Direccion> direccion = restDatosdireccion.findAll();

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
	 * Metodo que elimina un contacto de la BBDD. Le pasamos el ID de la Persona, y
	 * una vez borramos esta, automaticamente se borra tanto las direcciones como
	 * los telefonos asociados a esa persona
	 * 
	 * @author Grupo 1
	 * @param int idContacto
	 */

	public boolean borrarId(int idContacto) {

		// Eliminamos solo la persona porque en la BBDD esta puesto el DELETE ON
		// CASCADE, y todas las direcciones y telefono asociados al ID de esa persona,
		// seran eliminados una vez que la persona se elimine ademas retorna un tipo boolean ,si existe retorna true y si no existe (deberia lanzar false ya que no existe) false
		
		restDatospersona.deleteById(idContacto);
		
	
		return restDatospersona.existsById(idContacto);
	}
	
	/**
	/**
	 * Metodo que introduce un objeto de tipo contacto y es eliminada su
	 * encapsulacion partiendo el objeto en persona direccion y la lista de
	 * telefonos
	 * 
	 * @author grupo1
	 * @param Contacto
	
	
	public Contacto editarContacto(Contacto contacto) {
		restDatospersona.save(contacto.getPersona());
		restDatosdireccion.save(contacto.getDireccion());
		restDatostelefono.save(contacto.getTelefonomovil());
		
		return contacto;

	}
	
	/**
	 * Metodo que a partir de la ID de la persona te devuelve un objeto completo de Contacto
	 * 
	 * @author Grupo 1
	 * @param int idPersona
	 * @return Contacto
	 
	public Contacto BuscadorContacto(int idPersona) {

		ArrayList<Telefono> listaTelefonos = (ArrayList<Telefono>) restDatostelefono.findAll();

		Persona p = restDatospersona.getOne(idPersona);

		ArrayList<Telefono> misTelefonos = new ArrayList<Telefono>();

		for (Telefono t : listaTelefonos) {
			if (t.getPersona().getIdpersona() == idPersona) {
				misTelefonos.add(t);
			}
		}

		ArrayList<Direccion> misDirecciones = (ArrayList<Direccion>) restDatosdireccion.findAll();

		Direccion dir = null;

		for (Direccion d : misDirecciones) {
			if (d.getPersona().getIdpersona() == idPersona) {
				dir = d;
				break;
			}
		}
		if (misTelefonos.size() <= 1) {
			Telefono t = new Telefono();
			t.setPersona(p);
			return new Contacto(p, misTelefonos.get(0), dir);
		}
		return new Contacto(p, misTelefonos.get(0), dir);
	}
	 */
	
	
	
	public List buscarPorProvincia(String provincia) {
		
		 System.out.println("------------------------- inside Serviciosrest buscarPorProvincia ");
		 List l = restDatosprovincia.buscarPorProvincia(provincia);
		
		return l;
		
	}

	
}