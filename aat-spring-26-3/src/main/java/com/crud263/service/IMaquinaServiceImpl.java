package com.crud263.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud263.dao.IMaquinaDAO;
import com.crud263.dto.Maquina;


@Service
public class IMaquinaServiceImpl implements IMaquinaService {
	
	@Autowired
	IMaquinaDAO imaquinaDAO;

	//Listar todos
		public List<Maquina> listarMaquinas(){
			return imaquinaDAO.findAll();
		};
		
		
		//Listar por id
		public Maquina maquinaXID(Integer id) {
			return imaquinaDAO.findById(id).get();
		}; 
		
		//Guardar
		public Maquina guardarMaquina(Maquina maquina) {
			return imaquinaDAO.save(maquina);
		};
		
		//Actualizar
		public Maquina actualizarMaquina(Maquina maquina) {
			return imaquinaDAO.save(maquina);
		};
		
		//Eliminar
		public void eliminarMaquina(Integer id) {
			imaquinaDAO.deleteById(id);
		}		

}