package com.example.logirail_Spring_BBDD.interfaces;

import java.util.List;

import com.example.logirail_Spring_BBDD.model.Alumno;

public interface IAlumnoSERVICE {
	public List<Alumno> list_all_alumnos();
	public void add_alumno(Alumno a);
	public void delete_alumno(int id_alumno);
	public void update_alumno(Alumno a);
	public Alumno buscar_alumno(int id_alumno);
	public List<Alumno> filtrar_Nombre(String nombre);
	public List<Alumno> listar_Aprobados();

}
