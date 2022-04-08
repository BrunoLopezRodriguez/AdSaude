package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Localidad;

public interface LocalidadDAO {

	public  List<Localidad> findByProvincia(Connection c,int idProvincia) throws DataException;
}
