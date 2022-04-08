package com.bruno.adsaude.service;

import java.util.Date;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Incidencia;
import com.bruno.adsaude.model.IncidenciaDTO;

public interface IncidenciaService {
	
	public  List<IncidenciaDTO> findByDate(Date fechaDesde, Date fechaHasta)throws DataException, ServiceException;
	
	public  List<IncidenciaDTO> findByAsistidoAfectado(int id)throws DataException, ServiceException;
	
	public  List<IncidenciaDTO> findByCreador(Integer idasistido, Integer idfamiliar, Integer idempleado)throws DataException, ServiceException;
	
	public Incidencia create (Incidencia incidencia)throws DataException, ServiceException;

}
