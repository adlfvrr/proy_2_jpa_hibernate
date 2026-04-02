package com.proy.vehiculos_api.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Vehiculos")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "precio")
	private double precio;
	@Column(name = "anio")
	private int anio;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(String marca, double precio, int anio) {
		this.marca = marca;
		this.precio = precio;
		this.anio = anio;
	}

	//virtual toString
	
	public String toString() {
		return String.format("%d - %s - %f - %d ", this.getId(), this.getMarca(), this.getPrecio(), this.getAnio());
	}
	
}
