package com.proy.vehiculos_api.exception;

public class VehicleNotFoundException extends RuntimeException {
	
	public VehicleNotFoundException(int id) {
		super("Vehiculo con id " + id + " no encontrado");
	}
	
}
