package com.example.logirail_Spring_BBDD.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.logirail_Spring_BBDD.model.Alumno;
import com.example.logirail_Spring_BBDD.model.Producto;

public interface ProductoREPOSITORY extends CrudRepository<Producto, Integer> {
	// Producto es el model
	// Integer es el tipo de campo clave

	// Con ello Hibernate nos va a crear lo equivalente al dao pero mucho mas
	// completo en obciones

	
	public List<Producto> findByDescripcionContainingIgnoreCase(String descripcion);

	public List<Producto> findByIdcategoria(int idcategoria);

}
