package com.crud263.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud263.dao.ICajeroDAO;
import com.crud263.dto.Cajero;


@Service
public class ICajeroServiceImpl implements ICajeroService {
	
	@Autowired
	ICajeroDAO icajeroDAO;

	//Listar todos
		public List<Cajero> listarCajeros(){
			return icajeroDAO.findAll();
		};
		
		
		//Listar por id
		public Cajero cajeroXID(Integer id) {
			return icajeroDAO.findById(id).get();
		}; 
		
		//Guardar
		public Cajero guardarCajero(Cajero cajero) {
			return icajeroDAO.save(cajero);
		};
		
		//Actualizar
		public Cajero actualizarCajero(Cajero cajero) {
			return icajeroDAO.save(cajero);
		};
		
		//Eliminar
		public void eliminarCajero(Integer id) {
			icajeroDAO.deleteById(id);
		}		

}