package com.proy.vehiculos_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proy.vehiculos_api.entity.Vehiculo;
import com.proy.vehiculos_api.exception.*;
import com.proy.vehiculos_api.repository.VehiculoRepository;

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepository repository;
	
	public List<Vehiculo> obtenerTodos() {
		return this.repository.findAll();
	}

	public Vehiculo obtenerPorId(Long id) {
		
		if(id <= 0 || id == null) {
			throw new InvalidVehicleIdException(id);
		}
		
		return this.repository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
		
	}
	
	public Vehiculo actualizarVehiculo(Vehiculo v) {
		return this.repository.save(v);
		
	}
	
	public Vehiculo agregarVehiculo(Vehiculo v) {
		if(v.getAnio() == 0) {
			throw new WrongVehicleYearException("Ingresar año del vehículo");
		}
		else if(v.getMarca() == null) {
			throw new WrongVehicleBrandException("Ingresar marca del vehículo");
		}
		return this.repository.save(v);
		
	}
	
	public void borrarVehiculo(Long id) {
		if(id <= 0 || id == null) {
			throw new InvalidVehicleIdException(id);
		}
		this.repository.deleteById(id);
		
	}
}
