package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.RutaDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.RutaDTO;

public class RutaDAOImpl implements RutaDAO{

	private static Logger logger = LogManager.getLogger(RutaDAOImpl.class);
	
	public RutaDAOImpl() {

	}
	@Override
	public List<RutaDTO> findByEmpleado(Connection c, int idEmpleado) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<RutaDTO> rutas = null;
		try {
			String sql= "SELECT r.ID, r.DESCRIPCION, r.DIA_SEMANA, r.ID_EMPLEADO, e.NOMBRE, ra.NUMERO_ORDEN, a.ID, a.NOMBRE, a.DOMICILIO "
					+ " FROM RUTA r "
					+ " INNER JOIN EMPLEADO e ON r.ID_EMPLEADO = e.ID "
					+ " INNER JOIN RUTA_ASISTIDO ra ON r.ID = ra.ID_RUTA "
					+ " INNER JOIN ASISTIDO a ON a.ID = ra.ID_ASISTIDO "
					+ " WHERE r.ID_EMPLEADO = ? "
					+ " ORDER BY r.ID ASC ";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, idEmpleado);
			// Performing operation
			rs = stmt.executeQuery();
			rutas = new ArrayList <RutaDTO> ();
			RutaDTO r = null;
			while (rs.next()) {	
				r = loadNextDTO(rs);
				rutas.add(r);
			}
		} catch (SQLException e) {			
			logger.error(idEmpleado, e);
			throw new DataException(""+idEmpleado, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	

		return  rutas;
	}
	@Override
	public List<RutaDTO> findByAsistido(Connection c, int idAsistido) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<RutaDTO> rutas = null;
		try {
			String sql= "SELECT r.ID, r.DESCRIPCION, r.DIA_SEMANA, r.ID_EMPLEADO, e.NOMBRE, ra.NUMERO_ORDEN, a.ID, a.NOMBRE, a.DOMICILIO "
					+ " FROM RUTA r "
					+ " INNER JOIN EMPLEADO e ON r.ID_EMPLEADO = e.ID "
					+ " INNER JOIN RUTA_ASISTIDO ra ON r.ID = ra.ID_RUTA "
					+ " INNER JOIN ASISTIDO a ON a.ID = ra.ID_ASISTIDO "
					+ " WHERE ra.ID_ASISTIDO = ? "
					+ " ORDER BY r.ID ASC ";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, idAsistido);
			// Performing operation
			rs = stmt.executeQuery();
			rutas = new ArrayList <RutaDTO> ();
			RutaDTO r = null;
			while (rs.next()) {	
				r = loadNextDTO(rs);
				rutas.add(r);
			}

		} catch (SQLException e) {			
			logger.error(idAsistido, e);
			throw new DataException(""+idAsistido, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	

		return  rutas;
	}



	private static RutaDTO loadNextDTO(ResultSet rs)
			throws SQLException{
		RutaDTO r = new RutaDTO();

		int i = 1;
		r.setId(rs.getInt(i++));
		r.setDescripcion(rs.getString(i++));
		r.setDiaSemana(rs.getString(i++));
		r.setIdEmpleado(rs.getInt(i++));
		r.setNombreEmpleado(rs.getString(i++));
		r.setNumeroOrden(rs.getInt(i++));
		r.setIdAsistido(rs.getInt(i++));
		r.setNombreAsistido(rs.getString(i++));
		r.setDireccionAsistido(rs.getString(i++));



		return r;	
	}
}
