package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Empleado;
import com.bruno.adsaude.model.EmpleadoDTO;

public interface EmpleadoDAO {
	
	
	public  EmpleadoDTO findById(Connection c, int id)throws DataException;
	
	public  EmpleadoDTO findByEmail(Connection c, String email)throws DataException;
	
	public  List<EmpleadoDTO> findByServicio (Connection c, int idTipoServicio)throws DataException;
	
	public  int update(Connection c, Empleado empleado)throws DataException;

}
