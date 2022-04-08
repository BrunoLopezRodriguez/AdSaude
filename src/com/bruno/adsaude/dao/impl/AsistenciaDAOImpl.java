package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.AsistenciaDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;

public class AsistenciaDAOImpl implements AsistenciaDAO{
	
	private static Logger logger = LogManager.getLogger(AsistenciaDAOImpl.class);
	
	public AsistenciaDAOImpl () {
		
	}

	@Override
	public List<AsistenciaDTO> findByCriteria(Connection c, AsistenciaCriteria cr) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AsistenciaDTO> asistencia = null;
		try {
			// Creating statement
			StringBuilder sql = new StringBuilder("SELECT a.FECHA_HORA_INICIO, a.FECHA_HORA_FIN, a.ID_ASISTIDO,"
					+ " asi.NOMBRE, a.ID_TIPO_SERVICIO, ts.NOMBRE, a.ID_EMPLEADO, e.NOMBRE "
					+ " FROM ASISTENCIA a "
					+ " INNER JOIN ASISTIDO asi ON a.ID_ASISTIDO=asi.ID "
					+ " INNER JOIN TIPO_SERVICIO ts ON ts.ID=a.ID_TIPO_SERVICIO "
					+ " INNER JOIN EMPLEADO e ON a.ID_EMPLEADO=e.ID ");
			
			sql.append(JDBCUtils.queryCreator(cr));
			String sqlS=sql.toString();
			stmt = c.prepareStatement(sqlS);
			int i;
			i=1;
			if (cr.getFechaHoraInicio()!=null) {
				JDBCUtils.setParameter(stmt, i++, cr.getFechaHoraInicio());
			}
			if (cr.getFechaHoraFin()!=null) {
				JDBCUtils.setParameter(stmt, i++, cr.getFechaHoraFin());
			}
			if (cr.getIdAsistido()!=null) {
				JDBCUtils.setParameter(stmt, i++, cr.getIdAsistido());
			}
			if (cr.getIdServicio()!=null) {
				JDBCUtils.setParameter(stmt, i++, cr.getIdServicio());
			}
			if (cr.getIdEmpleado()!=null) {
				JDBCUtils.setParameter(stmt, i++, cr.getIdEmpleado());
			}
			// Performing operation
			rs = stmt.executeQuery();		
			asistencia = new ArrayList <AsistenciaDTO>();
			AsistenciaDTO a=null;
			while (rs.next()) {				
				a = loadNext(rs);								
				asistencia.add(a);										
			}			
			
		} catch (SQLException e) {			
			logger.error(cr, e);
			throw new DataException("Error Criteria", e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  asistencia;
	}
	
	private static AsistenciaDTO loadNext(ResultSet rs)
			throws SQLException{
		AsistenciaDTO a = new AsistenciaDTO();

		int i = 1;
		a.setFechaHoraInicio(rs.getDate(i++));
		a.setFechaHoraFin(rs.getDate(i++));
		a.setIdAsistido(rs.getInt(i++));
		a.setNombreAsistido(rs.getString(i++));
		a.setIdServicio(rs.getInt(i++));
		a.setNombreServicio(rs.getString(i++));
		a.setIdEmpleado(rs.getInt(i++));
		a.setNombreEmpleado(rs.getString(i++));
		return a;	
	}
}
