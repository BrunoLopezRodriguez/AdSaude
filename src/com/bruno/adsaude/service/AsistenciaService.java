package com.bruno.adsaude.service;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;
import com.bruno.adsaude.model.Results;

public interface AsistenciaService {

	public Results<AsistenciaDTO> findByCriteria (AsistenciaCriteria cr,  int startIndex, int pageSize) throws DataException, ServiceException ;
}
