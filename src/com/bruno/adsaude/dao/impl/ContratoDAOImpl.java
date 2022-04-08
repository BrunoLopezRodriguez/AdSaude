package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.ContratoDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Contrato;
import com.bruno.adsaude.model.ContratoDTO;

public class ContratoDAOImpl implements ContratoDAO{

	private static Logger logger = LogManager.getLogger(ContratoDAOImpl.class);
	
	public ContratoDAOImpl(){
		
	}
	
	public ContratoDTO findByAsistido (Connection c, int idAsistido)throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ContratoDTO contrato = null;
		try {
			
			String sql = "SELECT c.ID_CONTRATO, c.FECHA_INICIO, c.FECHA_FIN, c.ID_ASISTIDO, a.NOMBRE, cts.DESCRIPCION, cts.ID_TIPO_SERVICIO, ts.NOMBRE "
					+ " FROM CONTRATO c  "
					+ " INNER JOIN ASISTIDO a ON c.ID_ASISTIDO= a.ID "
					+ " INNER JOIN CONTRATO_TIPO_SERVICIO cts ON cts.ID_CONTRATO = c.ID_CONTRATO "
					+ " INNER JOIN TIPO_SERVICIO ts ON cts.ID_TIPO_SERVICIO = ts.ID "
					+ " WHERE c.ID_ASISTIDO = ? "
					+ " ORDER BY ts.NOMBRE ASC ";
			// Create prepared statement
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, idAsistido);
			// Performing operation
			rs = stmt.executeQuery();					
			while (rs.next()) {				
				contrato = loadNextDTO(rs);										
			}						
		} catch (SQLException e) {			
			logger.error(idAsistido, e);
			throw new DataException(""+idAsistido, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  contrato;
	}
	
	public Integer create (Connection c, Contrato contrato)throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql= "INSERT INTO CONTRATO (FECHA_INICIO, FECHA_FIN, ID_ASISTIDO) VALUES "
					+ " (?,?,?)" ;
			stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int i=1;
			
			JDBCUtils.setParameter(stmt, i++, contrato.getFechaInicio());
			JDBCUtils.setParameter(stmt, i++, contrato.getFechaFin());
			JDBCUtils.setParameter(stmt, i++, contrato.getIdAsistido());
			
			int insertedRows = stmt.executeUpdate();
			if (insertedRows ==1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					contrato.setIdContrato(rs.getInt(1));
					
				}
			}
			else {
				throw new DataException(contrato.getIdAsistido()+"");
			}
		} catch (SQLException e) {
			logger.error(contrato, e);
			throw new DataException(""+contrato, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}
		return contrato.getIdContrato();
	}
	
	
	
	private static ContratoDTO loadNextDTO(ResultSet rs)
			throws SQLException{
		ContratoDTO c = new ContratoDTO();
		int i = 1;
		c.setIdContrato(rs.getInt(i++));
		c.setFechaInicio(rs.getDate(i++));
		c.setFechaFin(rs.getDate(i++));
		c.setIdAsistido(rs.getInt(i++));
		c.setNombreAsistido(rs.getString(i++));
		c.setDescripcionNecesidad(rs.getString(i++));
		c.setIdTipoServicio(rs.getInt(i++));
		c.setNombreTipoServicio(rs.getString(i++));
		
		return c;
	}
	
}
