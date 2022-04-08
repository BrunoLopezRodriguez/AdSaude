package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.TipoEstadoIncidenciaDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.TipoEstadoIncidencia;

public class TipoEstadoIncidenciaDAOImpl implements TipoEstadoIncidenciaDAO{
	
	private static Logger logger = LogManager.getLogger(TipoEstadoIncidenciaDAOImpl.class);
	
	public TipoEstadoIncidenciaDAOImpl() {
		
	}
	@Override
	public  List<TipoEstadoIncidencia> findBy(Connection c)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoEstadoIncidencia> tei = null;
		
		try {
			String sql= "SELECT id, nombre" 
					+ " FROM TIPO_ESTADO_INCIDENCIA "
					+ " ORDER BY nombre ASC";
			stmt = c.prepareStatement(sql);
			// Performing operation
			rs = stmt.executeQuery();
			int i;
			tei = new ArrayList <TipoEstadoIncidencia>();
			TipoEstadoIncidencia a =null;
			while (rs.next()) {	
				a = new TipoEstadoIncidencia();
				
				i = 1;
				a.setId(rs.getInt(i++));
				a.setNombre(rs.getString(i++));
				
				tei.add(a);							
			}
		
		} catch (SQLException e) {			
			logger.error("Error FindAll", e);
			throw new DataException("ErrorFinadAll", e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  tei;
	}

}
