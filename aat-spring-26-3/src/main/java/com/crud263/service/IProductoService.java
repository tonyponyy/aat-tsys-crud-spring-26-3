package com.crud263.service;

import java.util.List;

import com.crud263.dto.Producto;


public interface IProductoService {
	
	//Listar todos
	public List<Producto> listarProductos();
	
	//Listar por id
	public Producto productoXID(Integer id); 
	
	//Guardar
	public Producto guardarProducto(Producto Fabricante);
	
	//Actualizar
	public Producto actualizarProducto(Producto Fabricante);
	
	//Eliminar
	public void eliminarProducto(Integer id);

	
}