package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.TipoEmpleadoDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.TipoEmpleado;

public class TipoEmpleadoDAOImpl implements TipoEmpleadoDAO{
	
	private static Logger logger = LogManager.getLogger(TipoEmpleadoDAOImpl.class);
	
	public TipoEmpleadoDAOImpl () {
		
	}
	@Override
	public  List<TipoEmpleado> findBy(Connection c)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoEmpleado> tipoEmpleado = null;
		try {
			String sql=  "SELECT ID, NOMBRE" 
					+ " FROM TIPO_EMPLEADO "
					+ " ORDER BY NOMBRE ASC";
			stmt = c.prepareStatement(sql);
			// Performing operation
			rs = stmt.executeQuery();
			int i;
			tipoEmpleado = new ArrayList <TipoEmpleado>();
			TipoEmpleado tp =null;
			while (rs.next()) {	
				tp = new TipoEmpleado();	
				i = 1;
				tp.setId(rs.getInt(i++));
				tp.setNombre(rs.getString(i++));	
				tipoEmpleado.add(tp);							
			}			
	
		} catch (SQLException e) {	
			logger.error("FindAll", e);
			throw new DataException("ErrorFindAll", e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  tipoEmpleado;
	}
}
