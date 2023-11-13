package com.crud263.service;

import java.util.List;

import com.crud263.dto.Maquina;


public interface IMaquinaService {
	
	//Listar todos
	public List<Maquina> listarMaquinas();
	
	//Listar por id
	public Maquina maquinaXID(Integer id); 
	
	//Guardar
	public Maquina guardarMaquina(Maquina maquina);
	
	//Actualizar
	public Maquina actualizarMaquina(Maquina maquina);
	
	//Eliminar
	public void eliminarMaquina(Integer id);

	
}