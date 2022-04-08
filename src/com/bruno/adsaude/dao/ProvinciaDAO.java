package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Provincia;

public interface ProvinciaDAO {

	public  List<Provincia> findByPais(Connection c,int idPais) throws DataException;
	
}
