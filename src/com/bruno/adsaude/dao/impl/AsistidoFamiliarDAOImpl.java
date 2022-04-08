package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.AsistidoFamiliarDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.AsistidoFamiliar;

public class AsistidoFamiliarDAOImpl implements AsistidoFamiliarDAO{
	
	private static Logger logger = LogManager.getLogger(AsistidoFamiliarDAOImpl.class);
	
	public AsistidoFamiliarDAOImpl () {
		
	}
	@Override
	public  void create (Connection c, AsistidoFamiliar asistidof) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql= " INSERT INTO ASISTIDO_FAMILIAR (ID_ASISTIDO, ID_FAMILIAR) VALUES (?,?)";
			
			stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			int i=1;
			JDBCUtils.setParameter(stmt, i++, asistidof.getIdAsistido());
			JDBCUtils.setParameter(stmt, i++, asistidof.getIdFamiliar());
			
			int insertedRows = stmt.executeUpdate();
			if (insertedRows ==1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					asistidof.setIdAsistido(rs.getInt(i++));
					asistidof.setIdFamiliar(rs.getInt(i++));
					
				}
			}
			else {
				throw new DataException(asistidof.getIdAsistido()+"");
				
			}
		} catch (SQLException e) {
			logger.error(asistidof, e);
			throw new DataException(""+asistidof.getIdAsistido(), e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}
		
	}
	
	@Override
	public  void delete(Connection c, int idAsistido, int idFamiliar) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int deletedRows = 0;
		try {
			
			
			String sql= " DELETE FROM ASISTIDO_FAMILIAR "
					+ " WHERE ID_ASISTIDO = ? AND ID_FAMILIAR = ?";
			
		stmt = c.prepareStatement(sql);
		int i = 1;
		JDBCUtils.setParameter(stmt, i++, idAsistido);
		JDBCUtils.setParameter(stmt, i++, idFamiliar);
		deletedRows = stmt.executeUpdate();
		if (deletedRows!=1) {
			throw new DataException(idAsistido+"");
		}
		
	}catch (SQLException e) {			
		logger.error(idAsistido, e);
		throw new DataException(""+idAsistido, e);
	} finally {
		JDBCUtils.closeResultSet(rs);
		JDBCUtils.closePreparedStatement(stmt);
	}
	
}

}
