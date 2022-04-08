package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.RutaDTO;

public interface RutaService {

	public List<RutaDTO> findByEmpleado(int idEmpleado)throws DataException, ServiceException;

	public List<RutaDTO> findByAsistido(int idAsistido)throws DataException, ServiceException;

}
