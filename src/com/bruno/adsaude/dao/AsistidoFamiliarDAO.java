package com.bruno.adsaude.dao;

import java.sql.Connection;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.AsistidoFamiliar;

public interface AsistidoFamiliarDAO {
	
	public  void create (Connection c, AsistidoFamiliar asistidof)throws DataException;
	
	public  void delete(Connection c, int idAsistido, int idFamiliar)throws DataException;

}
