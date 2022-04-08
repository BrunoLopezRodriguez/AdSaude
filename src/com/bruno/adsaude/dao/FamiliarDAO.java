package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Familiar;
import com.bruno.adsaude.model.FamiliarDTO;

public interface FamiliarDAO {

	public  List<FamiliarDTO> findByAsistido(Connection c,int id) throws DataException;
	
	public  FamiliarDTO findByEmail(Connection c,String email) throws DataException;
	
	public  FamiliarDTO findByDni (Connection c, String dni) throws DataException;
	
	public  Integer create (Connection c,Familiar familiar) throws DataException;
	
	public  int update(Connection c,Familiar familiar) throws DataException;
}
