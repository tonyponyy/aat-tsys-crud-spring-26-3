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

import com.crud263.dto.Cajero;
import com.crud263.service.ICajeroServiceImpl;


@RestController
@RequestMapping("/cajeros")
public class CajeroController {
	@Autowired
	private ICajeroServiceImpl cajeroServiceImpl;

	@GetMapping("/all")
	public List<Cajero> listarCajeros(){
		return cajeroServiceImpl.listarCajeros();
	}
	@PostMapping("/add")
	public Cajero salvarcajero(@RequestBody Cajero cajero) {
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	@GetMapping("/{id}")
	public Cajero cajeroXID(@PathVariable(name="id") Integer id) {
		Cajero cajero_xid= new Cajero();	
		cajero_xid=cajeroServiceImpl.cajeroXID(id);
		return cajero_xid;
	}
	
	@PutMapping("/{id}")
	public Cajero actualizarcajero(@PathVariable(name="id")Integer id,@RequestBody Cajero cajero) {
		
		Cajero cajero_seleccionado= new Cajero();
		Cajero cajero_actualizado= new Cajero();
		
		cajero_seleccionado= cajeroServiceImpl.cajeroXID(id);
		cajero_seleccionado.setNombre(cajero.getNombre());
		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);
		System.out.println("El cajero actualizado es: "+ cajero_actualizado);
		return cajero_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarcajero(@PathVariable(name="id")Integer id) {
		cajeroServiceImpl.eliminarCajero(id);
		System.out.println("cajero eliminado");
	}
	


}