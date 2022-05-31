package com.example.logirail_Spring_BBDD.util;

public class Descripcion_v {
	private String descripcion;

	public Descripcion_v() {
		super();
	}

	public Descripcion_v(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Descripcion_v [descripcion=" + descripcion + "]";
	}

}
