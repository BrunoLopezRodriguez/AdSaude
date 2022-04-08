package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.PaisDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Pais;

public class PaisDAOImpl implements PaisDAO{
	
	private static Logger logger = LogManager.getLogger(PaisDAOImpl.class);	

	public PaisDAOImpl() {

	}
	@Override
	public  List<Pais> findBy(Connection c)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Pais> pais = null;

		try {
			
			String sql="SELECT id, nombre" 
					+ " FROM PAIS "
					+" ORDER BY nombre ASC";
			stmt = c.prepareStatement(sql);
			// Performing operation
			int i =0;
			i=1;
			rs = stmt.executeQuery();
			pais = new ArrayList <Pais>();
			Pais p =null;
			while (rs.next()) {	
				p = new Pais();
				i = 1;
				p.setId(rs.getInt(i++));
				p.setNombre(rs.getString(i++));
				pais.add(p);
			}		
			
		} catch (SQLException e) {			
			logger.error("FindAll", e);
			throw new DataException(e.getMessage(), e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		return  pais;
	}
}
