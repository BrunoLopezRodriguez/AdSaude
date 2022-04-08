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

import com.bruno.adsaude.dao.ContratoTipoServicioDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.ContratoTipoServicio;

public class ContratoTipoServicioDAOImpl implements ContratoTipoServicioDAO{

	private static Logger logger = LogManager.getLogger(ContratoTipoServicioDAOImpl.class);
	
	public ContratoTipoServicioDAOImpl() {
		
	}
	@Override
	public Integer create (Connection c, ContratoTipoServicio contratoTipoServicio)throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql= "INSERT INTO CONTRATO_TIPO_SERVICIO (ID_CONTRATO, ID_TIPO_SERVICIO, DESCRIPCION) VALUES (?,?,?)" ;
			stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int i=1;
			
			JDBCUtils.setParameter(stmt, i++, contratoTipoServicio.getIdContrato());
			JDBCUtils.setParameter(stmt, i++, contratoTipoServicio.getIdTipoServicio());
			JDBCUtils.setParameter(stmt, i++, contratoTipoServicio.getDescripcion());
			
			int insertedRows = stmt.executeUpdate();
			if (insertedRows ==1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					contratoTipoServicio.setIdContrato(rs.getInt(1));
					
				}
			}
			else {
				throw new DataException(contratoTipoServicio.getIdContrato()+"");
			}
		} catch (SQLException e) {
			logger.error(contratoTipoServicio, e);
			throw new DataException(""+contratoTipoServicio.getIdContrato(), e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}
		return contratoTipoServicio.getIdContrato();
	}
	
	@Override
	public List<Integer> create (Connection c, List<ContratoTipoServicio> contratoTipoServicio)throws DataException {
		PreparedStatement stmt = null;
		Integer contador = 0;
		ResultSet rs = null;
		List<Integer> ids = new ArrayList<Integer>();
		
		try {
			String sql= "INSERT INTO CONTRATO_TIPO_SERVICIO (ID_CONTRATO, ID_TIPO_SERVICIO, DESCRIPCION) VALUES " ;
			
			StringBuilder sqlSb = new StringBuilder(sql);
			for (ContratoTipoServicio cts : contratoTipoServicio) {
				
				if(contador<contratoTipoServicio.size()-1) {
				    sqlSb.append(" (?,?,?) , ");
				}
				else {
					sqlSb.append(" (?,?,?) ");
				}
				contador++;
			}
			sqlSb.append(" ; ");
			
			sql=sqlSb.toString();
			stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int i=1;
			
			for (ContratoTipoServicio cts2 : contratoTipoServicio) {
			JDBCUtils.setParameter(stmt, i++, cts2.getIdContrato());
			JDBCUtils.setParameter(stmt, i++, cts2.getIdTipoServicio());
			JDBCUtils.setParameter(stmt, i++, cts2.getDescripcion());
			}
			int insertedRows = stmt.executeUpdate();
			if (insertedRows !=1) {
				rs = stmt.getGeneratedKeys();
				while (rs.next()) {
					for (ContratoTipoServicio cts : contratoTipoServicio) {
					cts.setIdContrato(rs.getInt(i++));
					ids.add(rs.getInt(i++));
					}
				}
			}
			else {
				throw new DataException("ListCTS");
			}
		} catch (SQLException e) {
			logger.error(contratoTipoServicio, e);
			throw new DataException("ListCTS", e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}
		return ids;
	}

	
}
