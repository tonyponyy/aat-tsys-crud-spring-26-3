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

import com.crud263.dto.Maquina;
import com.crud263.service.IMaquinaServiceImpl;


@RestController
@RequestMapping("/maquinas")
public class MaquinaController {
	@Autowired
	private IMaquinaServiceImpl maquinaServiceImpl;

	@GetMapping("/all")
	public List<Maquina> listarMaquinas(){
		return maquinaServiceImpl.listarMaquinas();
	}
	@PostMapping("/add")
	public Maquina salvarmaquina(@RequestBody Maquina maquina) {
		return maquinaServiceImpl.guardarMaquina(maquina);
	}
	@GetMapping("/{id}")
	public Maquina maquinaXID(@PathVariable(name="id") Integer id) {
		Maquina maquina_xid= new Maquina();	
		maquina_xid=maquinaServiceImpl.maquinaXID(id);
		return maquina_xid;
	}
	
	@PutMapping("/{id}")
	public Maquina actualizarmaquina(@PathVariable(name="id")Integer id,@RequestBody Maquina maquina) {
		
		Maquina maquina_seleccionado= new Maquina();
		Maquina maquina_actualizado= new Maquina();
		
		maquina_seleccionado= maquinaServiceImpl.maquinaXID(id);
		maquina_seleccionado.setPiso(maquina.getPiso());
		maquina_actualizado = maquinaServiceImpl.actualizarMaquina(maquina_seleccionado);
		System.out.println("El maquina actualizado es: "+ maquina_actualizado);
		return maquina_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarmaquina(@PathVariable(name="id")Integer id) {
		maquinaServiceImpl.eliminarMaquina(id);
		System.out.println("maquina eliminado");
	}
	


}