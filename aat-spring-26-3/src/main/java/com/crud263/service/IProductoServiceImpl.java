package com.crud263.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud263.dao.IProductoDAO;
import com.crud263.dto.Producto;


@Service
public class IProductoServiceImpl implements IProductoService {
	
	@Autowired
	IProductoDAO iproductoDAO;

	//Listar todos
		public List<Producto> listarProductos(){
			return iproductoDAO.findAll();
		};
		
		
		//Listar por id
		public Producto productoXID(Integer id) {
			return iproductoDAO.findById(id).get();
		}; 
		
		//Guardar
		public Producto guardarProducto(Producto producto) {
			return iproductoDAO.save(producto);
		};
		
		//Actualizar
		public Producto actualizarProducto(Producto producto) {
			return iproductoDAO.save(producto);
		};
		
		//Eliminar
		public void eliminarProducto(Integer id) {
			iproductoDAO.deleteById(id);
		}		

}