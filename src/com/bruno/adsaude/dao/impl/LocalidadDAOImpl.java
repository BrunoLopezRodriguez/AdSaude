package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.LocalidadDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Localidad;

public class LocalidadDAOImpl implements LocalidadDAO{
	
	private static Logger logger = LogManager.getLogger(LocalidadDAOImpl.class);
	
	public LocalidadDAOImpl() {
		
	}
	@Override
	public  List<Localidad> findByProvincia(Connection c,int idProvincia)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Localidad> localidad = null;
		
		try {
			
			String sql = "SELECT l.ID, l.NOMBRE, l.ID_PROVINCIA, p.NOMBRE" 
					+ " FROM LOCALIDAD l "
					+ " INNER JOIN PROVINCIA p"
					+ " ON p.ID = l.ID_PROVINCIA"
					+ " WHERE p.ID  = ? " 
					+ " ORDER BY l.NOMBRE ASC";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, idProvincia);
			// Performing operation
			rs = stmt.executeQuery();
			
			localidad = new ArrayList <Localidad>();
			Localidad l=null;
			while (rs.next()) {				
				
				l = new Localidad();
				
				i = 1;
				l.setId(rs.getInt(i++));
				l.setNombre(rs.getString(i++));
				l.setIdProvincia(rs.getInt(i++));
				l.setNombreProvincia(rs.getString(i++));	
				
				localidad.add(l);
				
										
			}			
			
		} catch (SQLException e) {			
			logger.error(idProvincia, e);
			throw new DataException(""+idProvincia, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  localidad;
	}
	
	
}
