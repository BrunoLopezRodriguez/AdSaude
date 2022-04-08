package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.RutaDTO;

public interface RutaDAO {
	
	public List<RutaDTO> findByEmpleado(Connection c, int idEmpleado) throws DataException;
	
	public List<RutaDTO> findByAsistido(Connection c, int idAsistido) throws DataException;

}
