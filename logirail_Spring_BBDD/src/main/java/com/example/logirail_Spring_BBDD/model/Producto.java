package com.example.logirail_Spring_BBDD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Hibernate automaticamente transforma la tabla a objeto

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@Column(name = "id_producto") // No haria falta porque se llama igual en la tabla
	private int id_producto;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "idcategoria")
	private int idcategoria;
	@Column(name = "precio")
	private double precio;
	@Column(name = "stock")
	private int stock;
	
	public Producto() {
		super();
	}

	public Producto(int id_producto, String descripcion, int idcategoria, double precio, int stock) {
		super();
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.idcategoria = idcategoria;
		this.precio = precio;
		this.stock = stock;
	}

	
	public int getId_producto() {
		return id_producto;
	}


	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getIdcategoria() {
		return idcategoria;
	}

	
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}

	public String toString() {
		return "\nProducto [id_producto=" + id_producto + ", descripcion=" + descripcion + ", idcategoria="
				+ idcategoria + ", precio=" + precio + ", stock=" + stock + "]";
	}

	
	
	
	
	
}
