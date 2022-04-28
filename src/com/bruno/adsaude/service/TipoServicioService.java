package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.TipoServicio;
import com.bruno.adsaude.model.TipoServicioDTO;

public interface TipoServicioService {
	
	public  TipoServicio findById(Integer id) throws DataException, ServiceException;	

	public  List<TipoServicio> findBy()throws DataException, ServiceException;
	
	public  List<TipoServicio> findByPadre()throws DataException, ServiceException;
	
	public  List<TipoServicioDTO> findByHijas()throws DataException, ServiceException;
	
	public  List<TipoServicio> findByPadreId(int idPadre)throws DataException, ServiceException;
}
