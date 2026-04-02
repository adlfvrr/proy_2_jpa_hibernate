package com.proy.vehiculos_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



//Clase GlobalExceptionHandler
//Se encarga de lanzar todas las excepciones anotadas como ExceptionHandler que capturaron la excepcion lanzada por el Service.
//Reciben la excepcion lanzada por el service y la lanzan al cliente en formato JSON mediante una ResponseEntity


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(VehicleNotFoundException.class)
	public ResponseEntity<String> handleVehicleNotFoundException(VehicleNotFoundException ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(WrongVehicleBrandException.class)
	public ResponseEntity<String> handleWrongVehicleBrandException(WrongVehicleBrandException ex){
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(WrongVehicleYearException.class)
	public ResponseEntity<String> handleWrongVehicleYearException(WrongVehicleYearException ex){
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(ex.getMessage());
	}
	
}
