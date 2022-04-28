package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.FamiliarDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Familiar;
import com.bruno.adsaude.model.FamiliarDTO;

public class FamiliarDAOImpl implements FamiliarDAO{
	
	private static Logger logger = LogManager.getLogger(FamiliarDAOImpl.class);
	StringBuilder sb= new StringBuilder(" ");
	public FamiliarDAOImpl() {
		
	}
	@Override
	public  List<FamiliarDTO> findByAsistido(Connection c,int id)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<FamiliarDTO> familiar = null;
		try {
			String sql= "SELECT f.ID, f.NOMBRE, f.APELLIDO1, f.APELLIDO2, f.NIF, f.TLF, f.EMAIL, f.PASSWORD_ENCRYPTED, f.DOMICILIO,"
						+ " f.ID_LOCALIDAD, l.NOMBRE "
						+ " FROM FAMILIAR f"
						+ " INNER JOIN LOCALIDAD l"
						+ " ON l.ID = f.ID_LOCALIDAD"
						+ " INNER JOIN ASISTIDO_FAMILIAR af"
						+ " ON af.ID_FAMILIAR = f.ID"
						+ " WHERE af.ID_ASISTIDO = ?"
						+ " ORDER BY f.NOMBRE ";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, id);
			// Performing operation
			rs = stmt.executeQuery();
			
		
			familiar = new ArrayList <FamiliarDTO>();
			FamiliarDTO f=null;
			while (rs.next()) {				
				f= loadNextDTO(rs);
				familiar.add(f);		
			}			

		} catch (SQLException e) {			
			logger.error(id, e);
			throw new DataException(""+id, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  familiar;
	}
	@Override
	public  FamiliarDTO findByEmail(Connection c,String email) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		FamiliarDTO familiar = null;
		try {
			String sql= "SELECT f.ID, f.NOMBRE, f.APELLIDO1, f.APELLIDO2, f.NIF, f.TLF, f.EMAIL, f.PASSWORD_ENCRYPTED, f.DOMICILIO,"
					+ " f.ID_LOCALIDAD, l.NOMBRE "
					+ " FROM FAMILIAR f"
					+ " INNER JOIN LOCALIDAD l"
					+ " ON f.ID_LOCALIDAD=l.ID"
					+ " WHERE UPPER(f.EMAIL) = ?";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, email);
			// Performing operation
			rs = stmt.executeQuery();
			
		
			
			FamiliarDTO f=null;
			while (rs.next()) {				
				
				f= loadNextDTO(rs);
				familiar = f;
			}			


		} catch (SQLException e) {			
			logger.error(email, e);
			throw new DataException(email, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  familiar;
	}
	
	@Override
	public  FamiliarDTO findByDni (Connection c, String dni) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		FamiliarDTO familiar = null;
		try {
			// Creating statement
			String sql= "SELECT f.ID, f.NOMBRE, f.APELLIDO1, f.APELLIDO2, f.NIF, f.TLF, f.EMAIL, f.PASSWORD_ENCRYPTED, f.DOMICILIO, "
					+ " f.ID_LOCALIDAD, l.NOMBRE "
					+ " FROM FAMILIAR f "
					+ " INNER JOIN LOCALIDAD l"
					+ " ON f.ID_LOCALIDAD=l.ID"
					+ " WHERE Upper(f.NIF) LIKE upper(?) ";
			// Create prepared statement
						stmt = c.prepareStatement(sql);
						int i;
						i=1;
						JDBCUtils.setParameter(stmt, i++, dni);
						// Performing operation
				
						
						rs = stmt.executeQuery();					
						while (rs.next()) {				
							familiar = loadNextDTO(rs);										
						}	
						
					} catch (SQLException e) {			
						logger.error(dni, e);
						throw new DataException(sb.append(dni).toString(), e);
					} finally {
						JDBCUtils.closeResultSet(rs);
						JDBCUtils.closePreparedStatement(stmt);	
					}	
					
					return  familiar;
				}
	
	@Override
	public  Integer create (Connection c,Familiar familiar)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql= " INSERT INTO FAMILIAR (NOMBRE, APELLIDO1, APELLIDO2, NIF, TLF , EMAIL,"
					+ " PASSWORD_ENCRYPTED, DOMICILIO, ID_LOCALIDAD) VALUES (?,?,?,?,?,?,?,?,?)";
			
			stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int i=1;
			JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getNombre());
			JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getApellido1());
			JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getApellido2());
			JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getNif());
			JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getTlf());
			JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getEmail());
			JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getPassword());
			JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getDomicilio());
			JDBCUtils.setParameter(stmt, i++, familiar.getIdLocalidad());
			
			int insertedRows = stmt.executeUpdate();
			if (insertedRows ==1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					familiar.setId(rs.getInt(1));
					
				}
			}
			else {
				throw new DataException(""+familiar.getEmail());
			}
		} catch (SQLException e) {
			logger.error(familiar, e);
			throw new DataException(""+familiar.getEmail(), e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}
		return familiar.getId();
	}
	@Override
	public  int update(Connection c,Familiar familiar)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int updatedRows = 0;
		try {
			String sql= " UPDATE FAMILIAR SET "
					+ " NOMBRE = ?, "
					+ " APELLIDO1 = ?, "
					+ " APELLIDO2 = ?, "
					+ " NIF = ?, "
					+ " TLF = ?, "
					+ " EMAIL = ?, "
					+ " PASSWORD_ENCRYPTED = ?, "
					+ " DOMICILIO = ?, "
					+ " ID_LOCALIDAD = ?"
					+ " WHERE ID = ? ";
			
		stmt = c.prepareStatement(sql);
		int i = 1;
		JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getNombre());
		JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getApellido1());
		JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getApellido2());
		JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getNif());
		JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getTlf());
		JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getEmail());
		JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getPassword());
		JDBCUtils.setParameterSinUpper(stmt, i++, familiar.getDomicilio());
		JDBCUtils.setParameter(stmt, i++, familiar.getIdLocalidad());
		JDBCUtils.setParameter(stmt, i++, familiar.getId());
		updatedRows = stmt.executeUpdate();
		if (updatedRows!=1) {
			throw new DataException(""+familiar.getEmail());
		}
		
	}catch (SQLException e) {			
		logger.error(familiar, e);
		throw new DataException(""+familiar.getEmail(), e);
	} finally {
		JDBCUtils.closeResultSet(rs);
		JDBCUtils.closePreparedStatement(stmt);
		
	}
	return updatedRows;
}
	
	
	private static FamiliarDTO loadNextDTO(ResultSet rs)
			throws SQLException{
		FamiliarDTO f = new FamiliarDTO();
		int i=1;
	
		f.setId(rs.getInt(i++));
		f.setNombre(rs.getString(i++));
		f.setApellido1(rs.getString(i++));
		f.setApellido2(rs.getString(i++));
		f.setNif(rs.getString(i++));
		f.setTlf(rs.getString(i++));
		f.setEmail(rs.getString(i++));
		f.setPassword(rs.getString(i++));
		f.setDomicilio(rs.getString(i++));
		f.setIdLocalidad(rs.getInt(i++));
		f.setNombreLocalidad(rs.getString(i++));
						
		return f;
	}
	
}
