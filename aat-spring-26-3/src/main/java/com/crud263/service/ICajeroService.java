package com.crud263.service;

import java.util.List;

import com.crud263.dto.Cajero;


public interface ICajeroService {
	
	//Listar todos
	public List<Cajero> listarCajeros();
	
	//Listar por id
	public Cajero cajeroXID(Integer id); 
	
	//Guardar
	public Cajero guardarCajero(Cajero Fabricante);
	
	//Actualizar
	public Cajero actualizarCajero(Cajero Fabricante);
	
	//Eliminar
	public void eliminarCajero(Integer id);

	
}