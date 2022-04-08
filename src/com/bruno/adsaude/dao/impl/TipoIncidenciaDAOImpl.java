package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.TipoIncidenciaDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.TipoIncidencia;

public class TipoIncidenciaDAOImpl implements TipoIncidenciaDAO{
	
	private static Logger logger = LogManager.getLogger(TipoIncidenciaDAOImpl.class);
	
	public TipoIncidenciaDAOImpl () {
		
	}
	@Override
	public  List<TipoIncidencia> findBy(Connection c)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoIncidencia> tipoIncidencia = null;
		try {
			
			String sql="SELECT ID, NOMBRE" 
					+ " FROM TIPO_INCIDENCIA "
					+ " ORDER BY ID ASC";
			stmt = c.prepareStatement(sql);
			// Performing operation
			rs = stmt.executeQuery();
			int i;
			tipoIncidencia = new ArrayList <TipoIncidencia>();
			TipoIncidencia ti= null;
			while (rs.next()) {				
				ti = new TipoIncidencia();
				
				i = 1;
				ti.setId(rs.getInt(i++));
				ti.setNombre(rs.getString(i++));
								
				tipoIncidencia.add(ti);							
			}				
		
		} catch (SQLException e) {			
			logger.error("FindAll", e);
			throw new DataException("ErrorFindAll", e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  tipoIncidencia;
	}

}
