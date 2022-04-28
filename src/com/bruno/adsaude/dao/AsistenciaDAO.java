package com.bruno.adsaude.dao;

import java.sql.Connection;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;
import com.bruno.adsaude.model.Results;

public interface AsistenciaDAO {

	public Results<AsistenciaDTO> findByCriteria (Connection c, AsistenciaCriteria cr,  int startIndex, int pageSize) throws DataException;
}
