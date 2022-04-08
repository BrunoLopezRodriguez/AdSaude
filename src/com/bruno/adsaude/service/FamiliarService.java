package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Familiar;
import com.bruno.adsaude.model.FamiliarDTO;

public interface FamiliarService {
	
	public  List<FamiliarDTO> findByAsistido(int id)throws DataException, ServiceException;
	
	public  FamiliarDTO login(String email, String password) throws DataException, ServiceException;
	
	public FamiliarDTO findByDni(String dni) throws DataException, ServiceException;
	
	public  Integer create (Familiar familiar)throws DataException, ServiceException;
	
	public  int update(Familiar familiar)throws DataException, ServiceException;

}
