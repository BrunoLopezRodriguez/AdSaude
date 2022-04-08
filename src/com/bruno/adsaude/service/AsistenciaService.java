package com.bruno.adsaude.service;

import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;

public interface AsistenciaService {

	public List<AsistenciaDTO> findByCriteria (AsistenciaCriteria cr) throws DataException, ServiceException ;
}
