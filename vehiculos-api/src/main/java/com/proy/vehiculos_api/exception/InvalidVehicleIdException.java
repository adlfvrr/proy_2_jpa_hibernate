package com.proy.vehiculos_api.exception;

public class InvalidVehicleIdException extends RuntimeException{

	public InvalidVehicleIdException(Long id) {
		super("El id " + id + " no puede ser null o menor a 0");
	}
	
}
