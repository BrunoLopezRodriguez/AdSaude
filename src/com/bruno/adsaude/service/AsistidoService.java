package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Asistido;
import com.bruno.adsaude.model.AsistidoDTO;

public interface AsistidoService {

	
	public  AsistidoDTO login(String email, String password) throws DataException, ServiceException;	
	
	public  List<AsistidoDTO> findByFamiliar ( int idFamiliar) throws DataException, ServiceException;
	
	public AsistidoDTO findByDni(String dni) throws DataException, ServiceException;
	
	public AsistidoDTO findByEmail(String email) throws DataException, ServiceException;
	
	public  List<AsistidoDTO> findByRuta ( int idRuta) throws DataException, ServiceException;
	
	public  Integer create (Asistido asistido) throws DataException, ServiceException;
	
	public  void update(Asistido asistido) throws DataException, ServiceException;	
	
}
