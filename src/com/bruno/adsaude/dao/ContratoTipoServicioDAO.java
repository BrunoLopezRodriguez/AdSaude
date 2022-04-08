package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.ContratoTipoServicio;

public interface ContratoTipoServicioDAO {
	
	public Integer create (Connection c, ContratoTipoServicio contratoTipoServicio)throws DataException;
	
	public List<Integer> create (Connection c, List<ContratoTipoServicio> contratoTipoServicio)throws DataException;

}
