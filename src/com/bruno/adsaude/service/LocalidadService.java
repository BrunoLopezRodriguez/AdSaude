package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Localidad;

public interface LocalidadService {

	public  List<Localidad> findByProvincia(int idProvincia)throws DataException, ServiceException;
}
