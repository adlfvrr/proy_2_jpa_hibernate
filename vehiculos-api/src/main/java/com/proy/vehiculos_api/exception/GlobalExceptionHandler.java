package com.proy.vehiculos_api.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
	public ResponseEntity<Map<String, Object>> handleVehicleNotFoundException(VehicleNotFoundException ex){
		Map<String, Object> exception = new HashMap<>();
		
		exception.put("timestamp", LocalDateTime.now());
		exception.put("status", HttpStatus.NOT_FOUND.value());
		exception.put("error", "Recurso no encontrado");
		exception.put("message", ex.getMessage());
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({WrongVehicleBrandException.class, WrongVehicleYearException.class, InvalidVehicleIdException.class})
	public ResponseEntity<Map<String, Object>> handleWrongVehicleBrandException(WrongVehicleBrandException ex){
		Map<String, Object> exception = new HashMap<>();
		
		exception.put("timestamp", LocalDateTime.now());
		exception.put("status", HttpStatus.BAD_REQUEST.value());
		exception.put("error", "Ingreso inválido de datos");
		exception.put("message", ex.getMessage());
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
}
