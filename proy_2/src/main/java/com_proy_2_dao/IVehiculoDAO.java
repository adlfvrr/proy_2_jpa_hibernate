package com_proy_2_dao;

import java.util.List;

import com_proy_2_entity.Vehiculo;

public interface IVehiculoDAO {

	List<Vehiculo> getAll();
	Vehiculo getById(int id);
	void save(Vehiculo v);
	void add(Vehiculo v);
	void remove(int id);
	
}
