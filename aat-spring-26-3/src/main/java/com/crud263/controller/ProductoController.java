package com.crud263.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud263.dto.Producto;
import com.crud263.service.IProductoServiceImpl;


@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private IProductoServiceImpl productoServiceImpl;

	@GetMapping("/all")
	public List<Producto> listarProductos(){
		return productoServiceImpl.listarProductos();
	}
	@PostMapping("/add")
	public Producto salvarproducto(@RequestBody Producto producto) {
		return productoServiceImpl.guardarProducto(producto);
	}
	@GetMapping("/{id}")
	public Producto productoXID(@PathVariable(name="id") Integer id) {
		Producto producto_xid= new Producto();	
		producto_xid=productoServiceImpl.productoXID(id);
		return producto_xid;
	}
	
	@PutMapping("/{id}")
	public Producto actualizarproducto(@PathVariable(name="id")Integer id,@RequestBody Producto producto) {
		
		Producto producto_seleccionado= new Producto();
		Producto producto_actualizado= new Producto();
		
		producto_seleccionado= productoServiceImpl.productoXID(id);
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		System.out.println("El producto actualizado es: "+ producto_actualizado);
		return producto_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarproducto(@PathVariable(name="id")Integer id) {
		productoServiceImpl.eliminarProducto(id);
		System.out.println("producto eliminado");
	}
	


}