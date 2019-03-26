package com.proyecto.spring.dao;


import java.util.List;

import com.proyecto.spring.model.Contacto;


public interface IProvinciaCustom {

	List<Contacto> buscarPorProvincia(String provincia);

}
