package com_proy_2_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "anio")
	private int anio;
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(String marca, double precio, int anio) {
		this.setMarca(marca);
		this.setPrecio(precio);
		this.setAnio(anio);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String toString() {
		return String.format("%d - %s - %f - %d ", this.getId(), this.getMarca(), this.getPrecio(), this.getAnio());
	}
}
