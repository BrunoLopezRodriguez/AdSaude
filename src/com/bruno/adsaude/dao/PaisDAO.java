package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Pais;

public interface PaisDAO {

	public  List<Pais> findBy(Connection c) throws DataException;
}
