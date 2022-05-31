package com.example.logirail_Spring_BBDD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.logirail_Spring_BBDD.interfaces.IAlumnoSERVICE;
import com.example.logirail_Spring_BBDD.model.Alumno;
import com.example.logirail_Spring_BBDD.repository.AlumnoREPOSITORY;

@Service
public class AlumnoSERVICE implements IAlumnoSERVICE {

	// Para inyectar el dao que nos ha creado automaticamente
	@Autowired
	AlumnoREPOSITORY alumnorepository;

	public List<Alumno> list_all_alumnos() {
		return (List<Alumno>) alumnorepository.findAll();
	}

	public void add_alumno(Alumno a) {
		alumnorepository.save(a);
	}

	public void delete_alumno(int id_alumno) {
		alumnorepository.deleteById(id_alumno);
	}

	public void update_alumno(Alumno a) {
		alumnorepository.save(a);
	}

	public Alumno buscar_alumno(int id_alumno) {
		return alumnorepository.findById(id_alumno).orElse(null);

	}

	public List<Alumno> filtrar_Nombre(String nombre) {
		return alumnorepository.findByNombreContainingIgnoreCase(nombre);
	}

	
	public List<Alumno> listar_Aprobados() {
		System.out.println("AlumnoSERVICE listaAprobados");
		return alumnorepository.listarAprobados();
		
	}
	

}
