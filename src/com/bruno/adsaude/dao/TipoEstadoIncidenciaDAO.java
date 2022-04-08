package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.TipoEstadoIncidencia;

public interface TipoEstadoIncidenciaDAO {

	
	public  List<TipoEstadoIncidencia> findBy(Connection c) throws DataException;
}
