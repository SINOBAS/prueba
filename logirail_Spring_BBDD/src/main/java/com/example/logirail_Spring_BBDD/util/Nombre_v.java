package com.example.logirail_Spring_BBDD.util;

public class Nombre_v {
	private String nombre;

	public Nombre_v() {
		super();
	}

	public Nombre_v(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre_v [nombre=" + nombre + "]";
	}

}
