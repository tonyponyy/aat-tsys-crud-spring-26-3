package com.crud263.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud263.dao.IVentaDAO;
import com.crud263.dto.Venta;


@Service
public class IVentaServiceImpl implements IVentaService {
	
	@Autowired
	IVentaDAO iventaDAO;

	//Listar todos
		public List<Venta> listarVentas(){
			return iventaDAO.findAll();
		};
		
		
		//Listar por id
		public Venta ventaXID(Integer id) {
			return iventaDAO.findById(id).get();
		}; 
		
		//Guardar
		public Venta guardarVenta(Venta venta) {
			return iventaDAO.save(venta);
		};
		
		//Actualizar
		public Venta actualizarVenta(Venta venta) {
			return iventaDAO.save(venta);
		};
		
		//Eliminar
		public void eliminarVenta(Integer id) {
			iventaDAO.deleteById(id);
		}



}