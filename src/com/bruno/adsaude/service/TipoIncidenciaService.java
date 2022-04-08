package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.TipoIncidencia;

public interface TipoIncidenciaService {

	public  List<TipoIncidencia> findBy()throws DataException, ServiceException;
}
