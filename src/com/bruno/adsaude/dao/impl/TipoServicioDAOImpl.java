package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.TipoServicioDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.TipoServicio;
import com.bruno.adsaude.model.TipoServicioDTO;

public class TipoServicioDAOImpl implements TipoServicioDAO{
	
	private static Logger logger = LogManager.getLogger(TipoServicioDAOImpl.class);
	
	public TipoServicioDAOImpl() {
		
	}
	
	@Override
	public  TipoServicio findById(Connection c, int id) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TipoServicio tipoServicio = null;
		try {
									
			String sql = "SELECT ID, NOMBRE, DESCRIPCION, TIEMPO_ESTIMADO ,ID_TIPO_SERVICIO  "
					+ " FROM TIPO_SERVICIO "
					+ " WHERE ID= ? ";
			// Create prepared statement
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, id);
			// Performing operation
	
			
			rs = stmt.executeQuery();					
			while (rs.next()) {				
				tipoServicio = loadNext(rs);										
			}	
			
		} catch (SQLException e) {			
			logger.error(id, e);
			throw new DataException("Tipo servicio find by"+id, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  tipoServicio;
	}
	
	
	
	@Override
	public  List<TipoServicio> findBy(Connection c) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoServicio> tipoServicio = null;
		try {
			
			String sql = "SELECT ID, NOMBRE, DESCRIPCION, TIEMPO_ESTIMADO ,ID_TIPO_SERVICIO " 
					+ " FROM TIPO_SERVICIO "
					+ " ORDER BY ID ASC";
			stmt = c.prepareStatement(sql);
			// Performing operation
			rs = stmt.executeQuery();
			tipoServicio = new ArrayList <TipoServicio>();
			TipoServicio ts = null;
			while (rs.next()) {				
				ts= loadNext(rs);
				tipoServicio.add(ts);							
			}			
		} catch (SQLException e) {			
			logger.error("FindAll", e);
			throw new DataException("ErrorFindAll", e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  tipoServicio;
	}
	@Override
	public  List<TipoServicio> findByPadre(Connection c)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoServicio> tipoServicio = null;
		try {
			String sql = "SELECT tspadre.ID, tspadre.NOMBRE"
					+ " FROM TIPO_SERVICIO tspadre"
					+ "		INNER JOIN TIPO_SERVICIO tshijo"
					+ "			ON tshijo.ID_TIPO_SERVICIO = tspadre.ID"
					+ " GROUP BY tspadre.ID "
					+ " ORDER BY tspadre.ID ";
			stmt = c.prepareStatement(sql);
			// Performing operation
			rs = stmt.executeQuery();
			int i;
			tipoServicio = new ArrayList <TipoServicio>();
			TipoServicio ts = null;
			while (rs.next()) {				
				ts= new TipoServicio();
				
				i = 1;
				ts.setId(rs.getInt(i++));
				ts.setNombre(rs.getString(i++));
				
								
				tipoServicio.add(ts);
										
			}			
		} catch (SQLException e) {			
			logger.error("FindByPadre", e);
			throw new DataException("ErrorFindByPadre", e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  tipoServicio;
	}
	
	@Override
	public  List<TipoServicioDTO> findByHijas(Connection c) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoServicioDTO> tipoServicio = null;
		try {
			String sql = "SELECT tshijo.ID, tshijo.NOMBRE, tshijo.DESCRIPCION, tshijo.TIEMPO_ESTIMADO, tshijo.ID_TIPO_SERVICIO, "
					+ " tspadre.ID, tspadre.NOMBRE "
					+ " FROM TIPO_SERVICIO tspadre "
					+ "		INNER JOIN TIPO_SERVICIO tshijo"
					+ "			ON tshijo.ID_TIPO_SERVICIO = tspadre.ID"
					+ "            order by ID_TIPO_SERVICIO;";
			stmt = c.prepareStatement(sql);
			// Performing operation
			rs = stmt.executeQuery();
			int i;
			tipoServicio = new ArrayList <TipoServicioDTO>();
			TipoServicioDTO ts = null;
			while (rs.next()) {				
				ts= new TipoServicioDTO();
				
				i = 1;
				ts.setId(rs.getInt(i++));
				ts.setNombre(rs.getString(i++));
				ts.setDescripcion(rs.getString(i++));
				ts.setTiempoEstimado(rs.getString(i++));
				ts.setIdTipoServicio(rs.getInt(i++));
				ts.setIdPadre(rs.getInt(i++));
				ts.setNombrePadre(rs.getString(i++));
				
								
				tipoServicio.add(ts);
										
			}			
		} catch (SQLException e) {			
			logger.error("FindByHijas", e);
			throw new DataException("ErrorFindByHijas", e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  tipoServicio;
	}
	@Override
	public  List<TipoServicio> findByPadreId(Connection c, int idPadre) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoServicio> tipoServicio = null;
		try {
			String sql = "SELECT ID,NOMBRE, DESCRIPCION, TIEMPO_ESTIMADO, ID_TIPO_SERVICIO"
					+ " FROM TIPO_SERVICIO"
					+ "	WHERE ID_TIPO_SERVICIO = ? "
					+ " ORDER BY NOMBRE ";
			stmt = c.prepareStatement(sql);
			
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, idPadre);
			// Performing operation
			rs = stmt.executeQuery();
			
			
			tipoServicio = new ArrayList <TipoServicio>();
			TipoServicio ts = null;
			while (rs.next()) {				
				ts= loadNext(rs);
				tipoServicio.add(ts);
										
			}			
		} catch (SQLException e) {			
			logger.error(idPadre, e);
			throw new DataException(""+idPadre, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  tipoServicio;
	}
	
	public static TipoServicio loadNext(ResultSet rs)
			throws SQLException{
		TipoServicio ts= new TipoServicio();
		
		int i = 1;
		ts.setId(rs.getInt(i++));
		ts.setNombre(rs.getString(i++));
		ts.setDescripcion(rs.getString(i++));
		ts.setTiempoEstimado(rs.getString(i++));
		ts.setIdTipoServicio(rs.getInt(i++));
						
		return ts;
	}
}
