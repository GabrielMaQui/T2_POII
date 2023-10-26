package com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import com.cibertec.models.*;
import com.cibertec.repository.*;

@Controller
public class CarritoController {
	private final IProductosRepositorio productoRepository;
	private final List<Productos> carrito = new ArrayList<>();

	public CarritoController(IProductosRepositorio productoRepository) {
		this.productoRepository = productoRepository;
	}

	@GetMapping("/verCarrito")
	public String verCarrito(Model model) {
		model.addAttribute("productosEnCarrito", carrito);
		return "carrito";
	}

	@PostMapping("/agregaralcarrito")
	public String agregarAlCarrito(@RequestParam("id") int productoid, @RequestParam("cantidad") int cantidad) {
		Productos producto = productoRepository.findById(productoid).orElse(null);
		if (producto.getCantidad() >= cantidad) {
			producto.setCantidad(producto.getCantidad() - cantidad);
			Productos productoEnCarrito = new Productos();
			productoEnCarrito.setId(producto.getId());
			productoEnCarrito.setNombre(producto.getNombre());
			productoEnCarrito.setDescripcion(producto.getDescripcion());
			productoEnCarrito.setPrecio(producto.getPrecio());
			productoEnCarrito.setCantidad(cantidad);

			carrito.add(productoEnCarrito);

			return "redirect:/verCarrito";
		} else
			return "error_inventario";
	}

	@GetMapping("/procesar-compra")
	public String procesarCompra(Model model) {
		model.addAttribute("productosEnCarrito", carrito);
		return "compra_exitosa";
	}

	@GetMapping("/cancelar")
	public String cancelarCompra() {
		carrito.clear();
		return "redirect:/Catalogo";
	}

}
