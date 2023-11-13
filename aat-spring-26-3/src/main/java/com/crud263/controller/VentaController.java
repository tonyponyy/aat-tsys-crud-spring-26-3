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

import com.crud263.dto.Venta;
import com.crud263.service.IVentaServiceImpl;


@RestController
@RequestMapping("/ventas")
public class VentaController {
	@Autowired
	private IVentaServiceImpl ventaServiceImpl;

	@GetMapping("/all")
	public List<Venta> listarVentas(){
		return ventaServiceImpl.listarVentas();
	}
	@PostMapping("/add")
	public Venta salvarventa(@RequestBody Venta venta) {
		return ventaServiceImpl.guardarVenta(venta);
	}
	@GetMapping("/{id}")
	public Venta ventaXID(@PathVariable(name="id") Integer id) {
		Venta venta_xid= new Venta();	
		venta_xid=ventaServiceImpl.ventaXID(id);
		return venta_xid;
	}
	
	@PutMapping("/{id}")
	public Venta actualizarventa(@PathVariable(name="id")Integer id,@RequestBody Venta venta) {
		
		Venta venta_seleccionado= new Venta();
		Venta venta_actualizado= new Venta();
		
		venta_seleccionado= ventaServiceImpl.ventaXID(id);
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setMaquina(venta.getMaquina());
		venta_seleccionado.setProducto(venta.getProducto());
		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionado);
		System.out.println("El venta actualizado es: "+ venta_actualizado);
		return venta_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarventa(@PathVariable(name="id")Integer id) {
		ventaServiceImpl.eliminarVenta(id);
		System.out.println("venta eliminado");
	}
	


}