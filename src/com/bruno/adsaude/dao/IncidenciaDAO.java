package com.bruno.adsaude.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Incidencia;
import com.bruno.adsaude.model.IncidenciaDTO;

public interface IncidenciaDAO {

	public  List<IncidenciaDTO> findByDate(Connection c,Date fechaDesde, Date fechaHasta) throws DataException;
	
	public  List<IncidenciaDTO> findByAsistidoAfectado(Connection c,int id) throws DataException;
	
	public  List<IncidenciaDTO> findByCreador(Connection c,Integer idasistido, Integer idfamiliar, Integer idempleado) throws DataException;
	
	public Incidencia create (Connection c,Incidencia incidencia) throws DataException;
}
