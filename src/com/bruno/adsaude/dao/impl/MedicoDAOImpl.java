package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.MedicoDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.MedicoDTO;

public class MedicoDAOImpl implements MedicoDAO{
	
	private static Logger logger = LogManager.getLogger(MedicoDAOImpl.class);
	
	public MedicoDAOImpl() {
		
	}

	@Override
	public  MedicoDTO findById(Connection c, int id) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MedicoDTO medico = null;
		try {
			
			String sql= "SELECT m.ID, m.NOMBRE, m.APELLIDO1, m.APELLIDO2, m.NIF, m.TLF, m.EMAIL, m.PASSWORD_ENCRYPTED, m.DOMICILIO, m.ID_LOCALIDAD, l.NOMBRE"
					+ " FROM MEDICO m"
					+ " INNER JOIN LOCALIDAD l"
					+ " ON m.ID_LOCALIDAD=l.ID"
					+ " WHERE m.ID = ?";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, id);
			// Performing operation
			rs = stmt.executeQuery();
			
			MedicoDTO m=null;
			while (rs.next()) {				
				m = loadNextDTO(rs);		
				medico=m;
										
			}			

		} catch (SQLException e) {			
			logger.error(id, e);
			throw new DataException(""+id, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  medico;
	}
	
	@Override
	public  MedicoDTO findByEmail(Connection c, String email) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MedicoDTO medico = null;
		try {
			
			String sql= "SELECT m.ID, m.NOMBRE, m.APELLIDO1, m.APELLIDO2, m.NIF, m.TLF, m.EMAIL, m.PASSWORD_ENCRYPTED, m.DOMICILIO, m.ID_LOCALIDAD, l.NOMBRE"
					+ " FROM MEDICO m"
					+ " INNER JOIN LOCALIDAD l"
					+ " ON m.ID_LOCALIDAD=l.ID"
					+ " WHERE UPPER(m.EMAIL) = ?";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, email);
			// Performing operation
			rs = stmt.executeQuery();
			
		
			
			MedicoDTO m=null;
			while (rs.next()) {				
				m = loadNextDTO(rs);		
				medico=m;
										
			}			

		} catch (SQLException e) {			
			logger.error(email, e);
			throw new DataException(email, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  medico;
	}
	
	private static MedicoDTO loadNextDTO(ResultSet rs)
			throws SQLException{
		MedicoDTO m = new MedicoDTO();
		int i=1;
	
		m.setId(rs.getInt(i++));
		m.setNombre(rs.getString(i++));
		m.setApellido1(rs.getString(i++));
		m.setApellido2(rs.getString(i++));
		m.setNif(rs.getString(i++));
		m.setTlf(rs.getString(i++));
		m.setEmail(rs.getString(i++));
		m.setPassword(rs.getString(i++));
		m.setDomicilio(rs.getString(i++));
		m.setIdLocalidad(rs.getInt(i++));
		m.setNombreLocalidad(rs.getString(i++));
						
		return m;
		
	}
	
}
