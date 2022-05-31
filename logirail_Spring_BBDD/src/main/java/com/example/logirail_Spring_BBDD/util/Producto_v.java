package com.example.logirail_Spring_BBDD.util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public class Producto_v {
	// Todas String porque las coge del formulario
	private String id_producto;
	private String descripcion;
	private String idcategoria;
	private String precio;
	private String stock;

	// -----------------------------------------------------metodos

	public Producto_v() {
		super();
	}

	public Producto_v(String id_producto, String descripcion, String idcategoria, String precio, String stock) {
		super();
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.idcategoria = idcategoria;
		this.stock = stock;
		this.precio = precio;
	}

	/**
	 * @return the id_producto
	 */
	public String getId_producto() {
		return id_producto;
	}

	/**
	 * @param id_producto the id_producto to set
	 */
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the idcategoria
	 */
	public String getIdcategoria() {
		return idcategoria;
	}

	/**
	 * @param idcategoria the idcategoria to set
	 */
	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	/**
	 * @return the precio
	 */
	public String getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	/**
	 * @return the stock
	 */
	public String getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "\nProducto_v [id_producto=" + id_producto + ", descripcion=" + descripcion + ", idcategoria="
				+ idcategoria + ", stock=" + stock  + ", precio=" + precio +"]";
	}

	// -----------------------------------------------------validaciones

	public boolean validate(Errors errors) {

		if (StringUtils.hasText("id_producto")) {
			try {
				Integer.parseInt(id_producto);
			} catch (Exception e) {
				errors.rejectValue("id_producto", "El id de producto debe ser un número");
			}
		} else {
			errors.rejectValue("id_producto", "Rellene el id de producto");
		}

		if (!StringUtils.hasText("descripcion")) {							//TODO NO LO VALIDA
			errors.rejectValue("descripcion", "Rellene la descripcion");
		}

		if (StringUtils.hasText("idcategoria")) {
			try {
				Integer.parseInt(idcategoria);
			} catch (Exception e) {
				errors.rejectValue("idcategoria", "La categoria debe ser un número");
			}
		} else {
			errors.rejectValue("id_producto", "Rellene la categoria");
		}

		if (StringUtils.hasText("precio")) {
			try {
				if (Double.parseDouble(precio) < 0.0) {
					errors.rejectValue("precio", "Precio debe ser mayor que 0");
				}
			} catch (Exception e) {
				errors.rejectValue("precio", "El precio debe ser un número");
			}
		} else {
			errors.rejectValue("precio", "Rellene el precio");
		}

		if (StringUtils.hasText("stock")) {
			try {
				Integer.parseInt(stock);
			} catch (Exception e) {
				errors.rejectValue("stock", "El stock debe ser un número");
			}
		} else {
			errors.rejectValue("stock", "Rellene el stock");
		}

		return errors.hasErrors();

	}
}
