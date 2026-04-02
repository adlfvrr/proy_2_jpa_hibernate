package com.proy.vehiculos_api.dto;

public class VehiculoDTO {
	
	final String marca;
	final double precio;
	final int anio;
	
	public String getMarca() {
		return this.marca;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public int getAnio() {
		return this.anio;
	}
	
	
	public VehiculoDTO(String marca, double precio, int anio) {
		this.marca = marca;
		this.precio = precio;
		this.anio = anio;
	}
	
}
