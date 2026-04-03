package com.proy.vehiculos_api.controller;

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

import com.proy.vehiculos_api.entity.Vehiculo;
import com.proy.vehiculos_api.service.VehiculoService;




@RestController
@RequestMapping("api/vehiculos")
public class VehiculoController {
	
	@Autowired
	VehiculoService service;
	
	//implementamos crud
	
	@GetMapping
	public List<Vehiculo> obtenerTodos(){
		return service.obtenerTodos();
	}
	
	@GetMapping("/{id}")
	public Vehiculo obtenerPorId(@PathVariable Long id) {
		return service.obtenerPorId(id);
	}
	
	@PostMapping
	public Vehiculo agregar(@RequestBody Vehiculo v) {
		return service.agregarVehiculo(v);
	}
	
	@PutMapping("/{id}")
	public Vehiculo actualizar(@RequestBody Vehiculo v) {
		return service.actualizarVehiculo(v);
	}

	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Long id) {
		service.borrarVehiculo(id);
	}
}
