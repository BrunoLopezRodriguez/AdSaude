package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.AsistenciaDTO;
import com.bruno.adsaude.model.AsistenciaCriteria;

public interface AsistenciaDAO {

	public List<AsistenciaDTO> findByCriteria (Connection c, AsistenciaCriteria cr) throws DataException;
}
