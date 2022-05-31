package com.example.logirail_Spring_BBDD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.logirail_Spring_BBDD.model.Alumno;

public interface AlumnoREPOSITORY extends CrudRepository<Alumno, Integer> {

	// Con el extendCrudRepositori, nos crea todos los metodos del dao

	// Para hacer filtro... nombre es estandar findBy+campo+tipobusqueda
	public List<Alumno> findByNombreContainingIgnoreCase(String nombre);
	
	//HQUERY para hacer consultas a medida
	//from es el equivalenmte al select. alumno es el objeto, es el beam que mapea con la tabla
	@Query(value="from Alumno where nota >= 5")
	public List<Alumno> listarAprobados();

}
