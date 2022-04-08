package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.TipoServicio;
import com.bruno.adsaude.model.TipoServicioDTO;

public interface TipoServicioDAO {
	
	public  List<TipoServicio> findBy(Connection c) throws DataException;
	
	public  List<TipoServicio> findByPadre(Connection c) throws DataException;
	
	public  List<TipoServicioDTO> findByHijas(Connection c) throws DataException;
	
	public  List<TipoServicio> findByPadreId(Connection c, int idPadre) throws DataException;
	

}
