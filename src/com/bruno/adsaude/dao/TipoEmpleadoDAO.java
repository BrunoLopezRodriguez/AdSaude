package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.TipoEmpleado;

public interface TipoEmpleadoDAO {
	
	public  List<TipoEmpleado> findBy(Connection c) throws DataException;

}
