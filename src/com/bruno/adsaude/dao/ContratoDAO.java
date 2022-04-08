package com.bruno.adsaude.dao;

import java.sql.Connection;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Contrato;
import com.bruno.adsaude.model.ContratoDTO;

public interface ContratoDAO {

	public ContratoDTO findByAsistido (Connection c, int idAsistido)throws DataException;
	
	public Integer create (Connection c, Contrato contrato)throws DataException;
}
