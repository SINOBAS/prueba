package com.example.logirail_Spring_BBDD.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.example.logirail_Spring_BBDD.model.Producto;

public interface IProductoSERVICE {
	public List<Producto> list_all_productos();

	public void add_producto(Producto p);

	public void delete_producto(int id_producto);

	public void editar_producto(Producto p);

	public Producto buscar_producto_by_id(int id_producto);

	public List<Producto> filtrar_descripcion(String descripcion);

	public List<Producto> buscar_producto_by_categoria(int id_producto);


}
