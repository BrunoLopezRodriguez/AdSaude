package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.ProvinciaDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Provincia;

public class ProvinciaDAOImpl implements ProvinciaDAO{

	private static Logger logger = LogManager.getLogger(ProvinciaDAOImpl.class);
	
	public ProvinciaDAOImpl () {

	}

	@Override
	public  List<Provincia> findByPais(Connection c, int idPais)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Provincia> provincia = null;
		try {
			
			String sql = "SELECT  pr.ID, pr.NOMBRE, pr.ID_PAIS, p.NOMBRE" 
					+ " FROM PROVINCIA pr "
					+ " INNER JOIN PAIS p"
					+ " ON p.ID = pr.ID_PAIS"
					+ " WHERE p.ID  = ?" 
					+ " ORDER BY pr.NOMBRE ASC";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, idPais);
			// Performing operation
			rs = stmt.executeQuery();
			provincia = new ArrayList <Provincia>();
			Provincia p =null;
			while (rs.next()) {				
				p = loadNext(rs);
				provincia.add(p);
			}			
		
		} catch (SQLException e) {			
			logger.error(idPais, e);
			throw new DataException(""+idPais, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	

		return  provincia;
	}

	
	
	private static Provincia loadNext(ResultSet rs)
			throws SQLException{

		Provincia p = new Provincia();


		int i = 1;
		p.setId(rs.getInt(i++));
		p.setNombre(rs.getString(i++));
		p.setIdPais(rs.getInt(i++));
		p.setNombrePais(rs.getString(i++));				

		return p;
		}
}
