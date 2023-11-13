package com.crud263.service;

import java.util.List;

import com.crud263.dto.Venta;


public interface IVentaService {
	
	//Listar todos
	public List<Venta> listarVentas();
	
	//Listar por id
	public Venta ventaXID(Integer id); 
	
	//Guardar
	public Venta guardarVenta(Venta venta);
	
	//Actualizar
	public Venta actualizarVenta(Venta venta);
	
	//Eliminar
	public void eliminarVenta(Integer id);

	
}