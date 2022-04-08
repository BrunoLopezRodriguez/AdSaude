package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Empleado;
import com.bruno.adsaude.model.EmpleadoDTO;

public interface EmpleadoService {
	
	public  EmpleadoDTO login(String email, String password) throws DataException, ServiceException;
	
	public  List<EmpleadoDTO> findByServicio (int idTipoServicio)throws DataException, ServiceException;
	
	public  int update(Empleado empleado)throws DataException, ServiceException;

}
