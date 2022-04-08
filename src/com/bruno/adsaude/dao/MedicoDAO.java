package com.bruno.adsaude.dao;

import java.sql.Connection;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.MedicoDTO;

public interface MedicoDAO {

	public  MedicoDTO findById(Connection c, int id) throws DataException;
	
	public  MedicoDTO findByEmail(Connection c, String email) throws DataException;
}
