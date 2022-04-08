package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Asistido;
import com.bruno.adsaude.model.AsistidoDTO;

public interface AsistidoDAO {
	
	public Asistido findById(Connection c, int id) throws DataException;
	
	public  AsistidoDTO findByEmail(Connection c, String email) throws DataException;
	
	public  List<AsistidoDTO> findByFamiliar (Connection c, int idFamiliar) throws DataException;
	
	public  AsistidoDTO findByDni (Connection c, String dni) throws DataException;
	
	public  List<AsistidoDTO> findByRuta (Connection c, int idRuta) throws DataException;
	
	public  Integer create (Connection c, Asistido asistido) throws DataException;
	
	public  void update(Connection c, Asistido asistido) throws DataException;

}
