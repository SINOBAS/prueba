package com.example.logirail_Spring_BBDD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.logirail_Spring_BBDD.interfaces.IAlumnoSERVICE;
import com.example.logirail_Spring_BBDD.interfaces.IProductoSERVICE;
import com.example.logirail_Spring_BBDD.model.Alumno;
import com.example.logirail_Spring_BBDD.model.Producto;
import com.example.logirail_Spring_BBDD.util.Alumno_v;
import com.example.logirail_Spring_BBDD.util.Descripcion_v;
import com.example.logirail_Spring_BBDD.util.Idcategoria_v;
import com.example.logirail_Spring_BBDD.util.Nombre_v;
import com.example.logirail_Spring_BBDD.util.Producto_v;

@Controller
public class MiControlador {

	// Inyectar el objeto (equivalente a crear el servicio)
	@Autowired
	IAlumnoSERVICE alumnoservice;
	@Autowired
	IProductoSERVICE productoservice;

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ GENERAL

	@GetMapping("/index")
	public String get_index() {
		return "index";
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ALUMNOS

	@GetMapping("/listaAlumnos")
	public String get_alumnos(Model model) {
		Nombre_v n_v = new Nombre_v();
		model.addAttribute("nombre_v", n_v);
		model.addAttribute("alumnos", alumnoservice.list_all_alumnos());
		return "listaAlumnos";
	}

	@GetMapping("/filtrarAlumno")
	public String get_alumnos(Model model, Nombre_v n_v) {
		// Nombre_v n_v = new Nombre_v();
		// model.addAttribute("nombre_v", n_v);
		model.addAttribute("alumnos", alumnoservice.filtrar_Nombre(n_v.getNombre()));
		return "listaAlumnos";
	}

	@GetMapping("/listarAprobados")
	public String get_alumnos_aprobados(Model model) {
		Nombre_v n_v = new Nombre_v();
		model.addAttribute("nombre_v", n_v);
		model.addAttribute("alumnos", alumnoservice.listar_Aprobados());
		return "listaAlumnos";
	}

	@GetMapping("/delete_alumno/{id_alumno}")
	public String delete_alumno(Model model, @PathVariable("id_alumno") int id_alumno) {
		Nombre_v n_v = new Nombre_v();
		model.addAttribute("nombre_v", n_v);
		alumnoservice.delete_alumno(id_alumno);
		model.addAttribute("alumnos", alumnoservice.list_all_alumnos());
		return "listaAlumnos";
	}

	@GetMapping("/altaAlumno")
	public String alta_alumno(Model model) {
		// Hay que hacerlo con alumno_v porque hay que hacerlo con string
		// Esto sólo nos saca el formulario html
		Alumno_v a_v = new Alumno_v();
		model.addAttribute("alumno_v", a_v);
		return "altaAlumno";
		// Formulario vacio--> que en el action llama a guardarAlumno
	}

	@GetMapping("/guardarAlumno")
	public String guardar_alumno(Model model, Alumno_v a_v, BindingResult br) {
		// Recogemos el alumno del formulario
		a_v.validate(br); // BindingResult es para los errores
		if (br.hasErrors()) {
			return "altaAlumno";
		} else {
			Alumno a = alumnoservice.buscar_alumno(Integer.parseInt(a_v.getId_alumno()));
			if (a == null) {
				// Si es null es que no está y lo creamos con los datos del formulario
				a = new Alumno(Integer.parseInt(a_v.getId_alumno()), a_v.getNombre(),
						Double.parseDouble(a_v.getNota()));
				alumnoservice.add_alumno(a);
				model.addAttribute("mensaje", "Alumno añadido");

			} else {
				model.addAttribute("mensaje", "Alumno ya existe");
			}
			return "altaAlumno";
		}

	}

	@GetMapping("/editar_alumno/{id_alumno}")
	public String editar_alumno(@PathVariable("id_alumno") int id_alumno, Model model) {
		Alumno a = alumnoservice.buscar_alumno(id_alumno);
		Alumno_v a_v = new Alumno_v("" + a.getId_alumno(), a.getNombre(), "" + a.getNota());
		model.addAttribute("alumno_v", a_v);
		return "editarAlumno";
	}

	@GetMapping("/modificarAlumno")
	public String modificar_alumno(Model model, Alumno_v a_v, BindingResult br) {
		// Recogemos el alumno del formulario
		a_v.validate(br); // BindingResult es para los errores
		if (br.hasErrors()) {
			return "altaAlumno";
		} else {
			Alumno a = alumnoservice.buscar_alumno(Integer.parseInt(a_v.getId_alumno()));
			if (a == null) {
				// Si es null es que no está y lo creamos con los datos del formulario
				// Aqui no entraria nunca

				model.addAttribute("mensaje", "Alumno no existe");

			} else {
				a = new Alumno(Integer.parseInt(a_v.getId_alumno()), a_v.getNombre(),
						Double.parseDouble(a_v.getNota()));
				alumnoservice.update_alumno(a);
				model.addAttribute("mensaje", "Alumno modificado");
			}
			return "editarAlumno";
		}
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++ PRODUCTOS

	@GetMapping("/listaProductos")
	public String get_productos(Model model) {
		// Id_Categoria_v i_c=new Id_Categoria_v();
		Descripcion_v d_v = new Descripcion_v();
		model.addAttribute("descripcion_v", d_v);
		model.addAttribute("productos", productoservice.list_all_productos());
		return "listaProductos";
	}

	@GetMapping("/filtrarProducto")
	public String get_productos(Model model, Descripcion_v d_v) {
		model.addAttribute("productos", productoservice.filtrar_descripcion(d_v.getDescripcion()));
		return "listaProductos";
	}

	@GetMapping("/filtrarProductoPorCategoria/{idcategoria}")
	//public String get_alumnos(Model model, @PathVariable("idcategoria") int idcategoria) {
		public String get_alumnos(Model model, Idcategoria_v c_v) {
		System.out.println("c_v "+c_v);
	//	System.out.println("idcategoria "+idcategoria);
	//	model.addAttribute("productos", productoservice.buscar_producto_by_categoria(idcategoria));
		return "listaProductos";
	}

	@GetMapping("/delete_producto/{id_producto}")
	public String delete_producto(Model model, @PathVariable("id_producto") int id_producto) {
		productoservice.delete_producto(id_producto);
		model.addAttribute("productos", productoservice.list_all_productos());
		return "listaProductos";
	}

	@GetMapping("/altaProducto")
	public String alta_producto(Model model) {
		Producto_v p_v = new Producto_v();
		model.addAttribute("producto_v", p_v);
		return "altaProducto";
	}

	@GetMapping("/guardarProducto")
	public String guardar_producto(Model model, Producto_v p_v, BindingResult br) {
		// Recogemos el producto del formulario
		p_v.validate(br); // BindingResult es para los errores
		if (br.hasErrors()) {
			return "altaProducto";
		} else {
			Producto a = productoservice.buscar_producto_by_id(Integer.parseInt(p_v.getId_producto()));
			if (a == null) {
				// Si es null es que no está y lo creamos con los datos del formulario
				a = new Producto(Integer.parseInt(p_v.getId_producto()), p_v.getDescripcion(),
						Integer.parseInt(p_v.getIdcategoria()), Double.parseDouble(p_v.getPrecio()),
						Integer.parseInt(p_v.getStock()));
				productoservice.add_producto(a);
				model.addAttribute("mensaje", "Producto añadido");

			} else {
				model.addAttribute("mensaje", "Producto ya existe");
			}
			return "altaProducto";
		}

	}

	@GetMapping("/editar_producto/{id_producto}")
	public String editarproducto(@PathVariable("id_producto") int id_producto, Model model) {
		Producto a = productoservice.buscar_producto_by_id(id_producto);
		// System.out.println("id_producto= "+id_producto);
		// System.out.println("a= "+a);
		Producto_v a_v = new Producto_v("" + a.getId_producto(), a.getDescripcion(), "" + a.getIdcategoria(),
				"" + a.getPrecio(), "" + a.getStock());
		// System.out.println("a_v= "+a_v);

		model.addAttribute("producto_v", a_v);
		return "editarProducto";
	}

	@GetMapping("/actualizarProducto")
	public String actualizar_producto(Model model, Producto_v p_v, BindingResult br) {
		// Recogemos el producto del formulario
		p_v.validate(br); // BindingResult es para los errores

		if (br.hasErrors()) {
			System.out.println("hasERRORS"); // TODO DEBERIA ENTRAR AQUI
			return "editarProducto";
		} else {
			Producto p = productoservice.buscar_producto_by_id(Integer.parseInt(p_v.getId_producto()));
			if (p == null) {
				System.out.println("producto no existe");

				model.addAttribute("mensaje", "Producto no existe");
			} else {
				System.out.println("producto modificado");

				p = new Producto(Integer.parseInt(p_v.getId_producto()), p_v.getDescripcion(),
						Integer.parseInt(p_v.getIdcategoria()), Double.parseDouble(p_v.getPrecio()),
						Integer.parseInt(p_v.getStock()));
				productoservice.editar_producto(p);
				model.addAttribute("mensaje", "Producto modificado");
			}
			return "editarProducto";
		}
	}

}
