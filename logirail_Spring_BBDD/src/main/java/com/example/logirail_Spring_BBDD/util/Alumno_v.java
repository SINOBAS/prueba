package com.example.logirail_Spring_BBDD.util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public class Alumno_v {
	// Todas String porque las coge del formulario
	private String id_alumno;
	private String nombre;
	private String nota;
	
	//-----------------------------------------------------metodos

	public Alumno_v() {
		super();
	}

	public Alumno_v(String id_alumno, String nombre, String nota) {
		super();
		this.id_alumno = id_alumno;
		this.nombre = nombre;
		this.nota = nota;
	}

	public String getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(String id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "\nAlumno_v [id_alumno=" + id_alumno + ", nombre=" + nombre + ", nota=" + nota + "]";
	}
	
	//-----------------------------------------------------validaciones

	public boolean validate(Errors errors) {

		if (StringUtils.hasText("id_alumno")) {
			try {
				Integer.parseInt(id_alumno);
			} catch (Exception e) {
				errors.rejectValue("id_alumno", "id_alumno debe ser un número");
			}
		}else {
			errors.rejectValue("id_alumno", "Rellene el id de alumno");
		}
		
		
		if (!StringUtils.hasText("nombre")){
			errors.rejectValue("nombre", "Rellene el nombre");
		}
		
		
		if (StringUtils.hasText("nota")) {
			try {
				if(Double.parseDouble(nota)<0.0 && Double.parseDouble(nota)>10.0) {
					errors.rejectValue("nota", "Nota debe estar entre 0 y 10");
				}
			} catch (Exception e) {
				errors.rejectValue("nota", "La Rellene debe ser un número");
			}
		}else {
			errors.rejectValue("nota", "Rellene la nota");
		}
		
		
		return errors.hasErrors();
	}

}
