package com.example.logirail_Spring_BBDD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Hibernate automaticamente transforma la tabla a objeto

@Entity
@Table(name = "alumnos")
public class Alumno {
	@Id
	@Column(name="id_alumno") //No haria falta porque se llama igual en la tabla
	private int id_alumno;
	@Column(name="nombre")
	private String nombre;
	@Column(name="nota")
	private double nota;

	public Alumno(int id_alumno, String nombre, double nota) {
		super();
		this.id_alumno = id_alumno;
		this.nombre = nombre;
		this.nota = nota;
	}

	public Alumno() {
		super();
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String toString() {
		return "\nAlumno [id_alumno=" + id_alumno + ", nombre=" + nombre + ", nota=" + nota + "]";
	}

}
