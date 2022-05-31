package com.example.logirail_Spring_BBDD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.logirail_Spring_BBDD.interfaces.IProductoSERVICE;
import com.example.logirail_Spring_BBDD.model.Producto;
import com.example.logirail_Spring_BBDD.repository.ProductoREPOSITORY;

@Service
public class ProductoSERVICE implements IProductoSERVICE {

	// Para inyectar el dao que nos ha creado automaticamente
	@Autowired
	ProductoREPOSITORY productorepository;

	public List<Producto> list_all_productos() {
		return (List<Producto>) productorepository.findAll();
	}

	public void add_producto(Producto p) {
		productorepository.save(p);
	}

	public void delete_producto(int id_producto) {
		productorepository.deleteById(id_producto);
	}

	public void editar_producto(Producto p) {
		productorepository.save(p);
	}

	public Producto buscar_producto_by_id(int id_producto) {
		return productorepository.findById(id_producto).orElse(null);
	}

	public List<Producto> filtrar_descripcion(String descripcion) {
		return productorepository.findByDescripcionContainingIgnoreCase(descripcion);
	}

	public List<Producto> buscar_producto_by_categoria(int idcategoria) {
		return productorepository.findByIdcategoria(idcategoria);

	}

}
