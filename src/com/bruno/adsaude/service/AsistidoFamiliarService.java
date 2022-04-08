package com.bruno.adsaude.service;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.AsistidoFamiliar;

public interface AsistidoFamiliarService {
	
	public  void create (AsistidoFamiliar asistidof)throws DataException, ServiceException;
	
	public  void delete(int idAsistido, int idFamiliar)throws DataException, ServiceException;


}
