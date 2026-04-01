package com.proy.vehiculos_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proy.vehiculos_api.entity.Vehiculo;
import com.proy.vehiculos_api.repository.VehiculoRepository;

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepository repository;
	
	public List<Vehiculo> obtenerTodos() {
		return this.repository.findAll();
	}

	public Vehiculo obtenerPorId(int id) {
		if(id <= 0) {
			throw new RuntimeException("La id debe ser mayor a 0");
		}
		return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Vehiculo con id " + id + " no fue encontrado"));
	}
	
	public Vehiculo actualizarVehiculo(Vehiculo v) {
		return this.repository.save(v);
		
	}
	
	public Vehiculo agregarVehiculo(Vehiculo v) {
		return this.repository.save(v);
		
	}
	
	public void borrarVehiculo(int id) {
		if(id <= 0) {
			throw new RuntimeException("La id debe ser mayor a 0");
		}
		this.repository.deleteById(id);
		
	}
}
