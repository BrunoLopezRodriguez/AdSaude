package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Provincia;

public interface ProvinciaService {

	public  List<Provincia> findByPais(int idPais)throws DataException, ServiceException;

}
