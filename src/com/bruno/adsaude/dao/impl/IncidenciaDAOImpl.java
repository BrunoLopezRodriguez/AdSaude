package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.IncidenciaDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Incidencia;
import com.bruno.adsaude.model.IncidenciaDTO;


public class IncidenciaDAOImpl implements IncidenciaDAO{
	
	private static Logger logger = LogManager.getLogger(IncidenciaDAOImpl.class);
	
	public IncidenciaDAOImpl() {
		
	}
	@Override
	public  List<IncidenciaDTO> findByDate(Connection c,Date fechaDesde, Date fechaHasta)  throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<IncidenciaDTO> incidencia = null;
		try {
			String sql = "SELECT i.ID, i.RESUMEN, i.DESCRIPCION, i.FECHA_HORA, i.ID_TIPO_ESTADO_INCIDENCIA,"
					+ " tei.nombre, i.ID_TIPO_INCIDENCIA, ti.nombre, i.ID_FAMILIAR_CREADOR, "
					+ " f.nombre, i.ID_ASISTIDO_CREADOR, a.nombre, i.ID_EMPLEADO_CREADOR, e.nombre, i.ID_ASISTIDO, a.nombre" 
					+ " FROM INCIDENCIA i  "
					+ " INNER JOIN TIPO_ESTADO_INCIDENCIA tei ON tei.ID= i.ID_TIPO_ESTADO_INCIDENCIA "
					+ " INNER JOIN TIPO_INCIDENCIA ti ON ti.ID= i.ID_TIPO_INCIDENCIA "
					+ " LEFT OUTER JOIN FAMILIAR f ON f.ID= i.ID_FAMILIAR_CREADOR "
					+ " LEFT OUTER JOIN ASISTIDO a ON a.ID= i.ID_ASISTIDO_CREADOR "
					+ " LEFT OUTER JOIN EMPLEADO e ON e.ID= i.ID_EMPLEADO_CREADOR "
					+ " WHERE i.FECHA_HORA > ? "
					+ " AND i.FECHA_HORA < ? "
					+ " ORDER BY i.FECHA_HORA ASC ";
			stmt = c.prepareStatement(sql);
			// Performing operation
			int i;
			i = 1;
			JDBCUtils.setParameter(stmt, i++, fechaDesde);
			JDBCUtils.setParameter(stmt, i++, fechaHasta);
			
			rs= stmt.executeQuery();
			incidencia = new ArrayList<IncidenciaDTO>();
			IncidenciaDTO inc = null;
			
			while (rs.next()) {				
				inc = loadNextDTO(rs);
				incidencia.add(inc);
			}			

		} catch (SQLException e) {			
			logger.error(fechaDesde, e);
			throw new DataException(""+fechaDesde, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  incidencia;
	}
	@Override
	public  List<IncidenciaDTO> findByAsistidoAfectado(Connection c,int id) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<IncidenciaDTO> incidencia = null;
		try {
			String sql = "SELECT i.ID, i.RESUMEN, i.DESCRIPCION, i.FECHA_HORA, i.ID_TIPO_ESTADO_INCIDENCIA,"
					+ " tei.nombre, i.ID_TIPO_INCIDENCIA, ti.nombre, i.ID_FAMILIAR_CREADOR, "
					+ " f.nombre, i.ID_ASISTIDO_CREADOR, a.nombre, i.ID_EMPLEADO_CREADOR, e.nombre, i.ID_ASISTIDO, a.nombre" 
					+ " FROM INCIDENCIA i  "
					+ " INNER JOIN TIPO_ESTADO_INCIDENCIA tei ON tei.ID= i.ID_TIPO_ESTADO_INCIDENCIA "
					+ " INNER JOIN TIPO_INCIDENCIA ti ON ti.ID= i.ID_TIPO_INCIDENCIA "
					+ " LEFT OUTER JOIN FAMILIAR f ON f.ID= i.ID_FAMILIAR_CREADOR "
					+ " LEFT OUTER JOIN ASISTIDO a ON a.ID= i.ID_ASISTIDO_CREADOR "
					+ " LEFT OUTER JOIN EMPLEADO e ON e.ID= i.ID_EMPLEADO_CREADOR "
					+ " WHERE i.ID_ASISTIDO = ? "
					+ " ORDER BY i.FECHA_HORA ASC ";
			stmt = c.prepareStatement(sql);
			// Performing operation
			int i;
			i = 1;
			JDBCUtils.setParameter(stmt, i++, id);
			
			rs= stmt.executeQuery();
			incidencia = new ArrayList<IncidenciaDTO>();
			IncidenciaDTO inc = null;
			
			while (rs.next()) {				
				inc = loadNextDTO(rs);
				incidencia.add(inc);
			}			

		} catch (SQLException e) {			
			logger.error(id, e);
			throw new DataException(""+id, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  incidencia;
		
	}
	@Override
	public  List<IncidenciaDTO> findByCreador(Connection c,Integer idasistido, Integer idfamiliar, Integer idempleado) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<IncidenciaDTO> incidencia = null;
		
		try {
			String sql = "SELECT i.ID, i.RESUMEN, i.DESCRIPCION, i.FECHA_HORA, i.ID_TIPO_ESTADO_INCIDENCIA,"
					+ " tei.nombre, i.ID_TIPO_INCIDENCIA, ti.nombre, i.ID_FAMILIAR_CREADOR, "
					+ " f.nombre, i.ID_ASISTIDO_CREADOR, a.nombre, i.ID_EMPLEADO_CREADOR, e.nombre, i.ID_ASISTIDO, a.nombre" 
					+ " FROM INCIDENCIA i  "
					+ " INNER JOIN TIPO_ESTADO_INCIDENCIA tei ON tei.ID= i.ID_TIPO_ESTADO_INCIDENCIA "
					+ " INNER JOIN TIPO_INCIDENCIA ti ON ti.ID= i.ID_TIPO_INCIDENCIA "
					+ " LEFT OUTER JOIN FAMILIAR f ON f.ID= i.ID_FAMILIAR_CREADOR "
					+ " LEFT OUTER JOIN ASISTIDO a ON a.ID= i.ID_ASISTIDO_CREADOR "
					+ " LEFT OUTER JOIN EMPLEADO e ON e.ID= i.ID_EMPLEADO_CREADOR "
					+ " WHERE ";
			
			StringBuilder sqlSb = new StringBuilder(sql);
			
					if (idasistido!=null) {
					sqlSb.append(" i.ID_ASISTIDO_CREADOR = ? ");
						}
					else if (idfamiliar!=null) {
					 sqlSb.append(" i.ID_FAMILIAR_CREADOR = ? ");
					}
					else if (idempleado!=null) {
					sqlSb.append(" i.ID_EMPLEADO_CREADOR = ? ");
					}
					
					sqlSb.append(" ORDER BY i.FECHA_HORA ASC ");
					
					sql=sqlSb.toString();
				
			stmt = c.prepareStatement(sql);
			// Performing operation
						int i;
						i = 1;
						if (idasistido!=null) {
						JDBCUtils.setParameter(stmt, i++, idasistido);
						}
						else if (idfamiliar!=null) {
						JDBCUtils.setParameter(stmt, i++, idfamiliar);
						}
						else if (idempleado!=null) {
						JDBCUtils.setParameter(stmt, i++, idempleado);
						}
						
						rs= stmt.executeQuery();
						incidencia = new ArrayList<IncidenciaDTO>();
						IncidenciaDTO inc = null;
						
						while (rs.next()) {				
							inc = loadNextDTO(rs);
							incidencia.add(inc);
						}			

					} catch (SQLException e) {			
						logger.error(idasistido, e);
						throw new DataException(""+idasistido+" "+idfamiliar+" "+idempleado, e);
					} finally {
						JDBCUtils.closeResultSet(rs);
						JDBCUtils.closePreparedStatement(stmt);
					}	
					
					return  incidencia;
	}
		
	@Override
	public Incidencia create (Connection c,Incidencia incidencia) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql= " INSERT INTO INCIDENCIA (RESUMEN, DESCRIPCION, FECHA_HORA, ID_TIPO_ESTADO_INCIDENCIA, "
					+ " ID_TIPO_INCIDENCIA, ";
			
					StringBuilder sqlSb = new StringBuilder(sql);
					if(incidencia.getIdFamiliar()!=null) {
						sqlSb.append(" ID_FAMILIAR_CREADOR, ");
					}
					if(incidencia.getIdAsistido()!=null) {
						sqlSb.append(" ID_ASISTIDO_CREADOR, ");
					}
					if(incidencia.getIdEmpleado()!=null) {
						sqlSb.append(" ID_EMPLEADO_CREADOR, ");
					}
					
					sqlSb.append(" ID_ASISTIDO) VALUES ( ?, ?, ?, ?, ?, ?, ? )");
					
				sql=sqlSb.toString();
					
			stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int i=1;
			JDBCUtils.setParameterSinUpper(stmt, i++, incidencia.getResumen());
			JDBCUtils.setParameterSinUpper(stmt, i++, incidencia.getDescripcion());
			JDBCUtils.setParameter(stmt, i++, incidencia.getFechaHora());
			JDBCUtils.setParameter(stmt, i++, incidencia.getIdTipoEstadoIncidencia());
			JDBCUtils.setParameter(stmt, i++, incidencia.getIdTipoIncidencia());
			if(incidencia.getIdFamiliar()!=null) {
			JDBCUtils.setParameter(stmt, i++, incidencia.getIdFamiliar());
			}
			if(incidencia.getIdAsistido()!=null) {
			JDBCUtils.setParameter(stmt, i++, incidencia.getIdAsistido());
			}
			if(incidencia.getIdEmpleado()!=null) {
			JDBCUtils.setParameter(stmt, i++, incidencia.getIdEmpleado());
			}
			JDBCUtils.setParameter(stmt, i++, incidencia.getIdAsistidoAfectado());
			
			int insertedRows = stmt.executeUpdate();
			if (insertedRows ==1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					incidencia.setId(rs.getInt(1));
					
				}
			}
			else {
				throw new DataException(""+incidencia.getId());
			}
		} catch (SQLException e) {
			logger.error(incidencia, e);
			throw new DataException(""+incidencia.getId(), e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}
		return incidencia;
	}
	
	
	private static IncidenciaDTO loadNextDTO(ResultSet rs)
			throws SQLException{
		IncidenciaDTO incidencia = new IncidenciaDTO();
		
		int i = 1;
		incidencia.setId(rs.getInt(i++));
		incidencia.setResumen(rs.getString(i++));
		incidencia.setDescripcion(rs.getString(i++));
		incidencia.setFechaHora(rs.getString(i++));
		incidencia.setIdTipoEstadoIncidencia(rs.getInt(i++));
		incidencia.setNombreTipoEstadoIncidencia(rs.getString(i++));
		incidencia.setIdTipoIncidencia(rs.getInt(i++));
		incidencia.setNombreTipoIncidencia(rs.getString(i++));
		incidencia.setIdFamiliar(rs.getInt(i++));
		incidencia.setNombreFamiliar(rs.getString(i++));
		incidencia.setIdAsistido(rs.getInt(i++));
		incidencia.setNombreAsistido(rs.getString(i++));
		incidencia.setIdEmpleado(rs.getInt(i++));
		incidencia.setNombreEmpleado(rs.getString(i++));
		incidencia.setIdAsistidoAfectado(rs.getInt(i++));
		incidencia.setNombreAsistidoAfectado(rs.getString(i++));
		
		return incidencia;
	}
}