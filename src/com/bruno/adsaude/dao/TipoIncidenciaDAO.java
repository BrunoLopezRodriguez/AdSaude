package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.TipoIncidencia;

public interface TipoIncidenciaDAO {
	
	public  List<TipoIncidencia> findBy(Connection c) throws DataException;

}
