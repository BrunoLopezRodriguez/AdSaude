package com.bruno.adsaude.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.EmpleadoDAO;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Empleado;
import com.bruno.adsaude.model.EmpleadoDTO;

public class EmpleadoDAOImpl implements EmpleadoDAO{
	
	private static Logger logger = LogManager.getLogger(EmpleadoDAOImpl.class);
	
	public EmpleadoDAOImpl() {
		
	}
	@Override
	public  EmpleadoDTO findById(Connection c, int id)throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		EmpleadoDTO empleado = null;
		try {
			
			String sql = " SELECT e.ID, e.NOMBRE, e.APELLIDO1, e.APELLIDO2, e.NIF, TLF, e.EMAIL, e.PASSWORD_ENCRYPTED"
					+ " e.DOMICILIO, e.ID_TIPO_EMPLEADO, te.NOMBRE, e.ID_LOCALIDAD, l.NOMBRE " 
					+ " FROM EMPLEADO e "
					+ " INNER JOIN LOCALIDAD l"
					+ " ON l.ID = e.ID_LOCALIDAD"
					+ " INNER JOIN TIPO_EMPLEADO te"
					+ " ON te.ID= e.ID_TIPO_EMPLEADO"
					+ " WHERE e.ID = ? ";
			
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, id);
			// Performing operation
			rs = stmt.executeQuery();
	
			while (rs.next()) {				
				empleado = loadNextDTO(rs);
											
			}			

		} catch (SQLException e) {			
			logger.error(id, e);
			throw new DataException(""+id, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  empleado;
	}
	@Override
	public  EmpleadoDTO findByEmail(Connection c, String email) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		EmpleadoDTO empleado = null;
		try {
			String sql = " SELECT e.ID, e.NOMBRE, e.APELLIDO1, e.APELLIDO2, e.NIF, TLF, e.EMAIL, e.PASSWORD_ENCRYPTED, "
					+ " e.DOMICILIO, e.ID_TIPO_EMPLEADO, te.NOMBRE, e.ID_LOCALIDAD, l.NOMBRE " 
					+ " FROM EMPLEADO e "
					+ " INNER JOIN LOCALIDAD l"
					+ " ON l.ID = e.ID_LOCALIDAD"
					+ " INNER JOIN TIPO_EMPLEADO te"
					+ " ON te.ID= e.ID_TIPO_EMPLEADO"
					+ " WHERE UPPER(e.EMAIL) = ? ";
			
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, email);
			// Performing operation
			rs = stmt.executeQuery();
		
		

			while (rs.next()) {				
				empleado = loadNextDTO(rs);								
			}			

		
		} catch (SQLException e) {			
			logger.error(email, e);
			throw new DataException(email , e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  empleado;
	}
	@Override
	public  List<EmpleadoDTO> findByServicio (Connection c, int idTipoServicio) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<EmpleadoDTO> empleado = null;
		try {
			String sql = " SELECT e.ID, e.NOMBRE, e.APELLIDO1, e.APELLIDO2, e.NIF, TLF, e.EMAIL, e.PASSWORD_ENCRYPTED, "
					+ " e.DOMICILIO, e.ID_TIPO_EMPLEADO, te.NOMBRE, e.ID_LOCALIDAD, l.NOMBRE " 
					+ " FROM EMPLEADO e "
					+ " INNER JOIN LOCALIDAD l"
					+ " ON l.ID = e.ID_LOCALIDAD"
					+ " INNER JOIN TIPO_EMPLEADO te"
					+ " ON te.ID= e.ID_TIPO_EMPLEADO"
					+ " INNER JOIN ASISTENCIA a ON a.ID_EMPLEADO = e.ID"
					+ " WHERE a.ID_TIPO_SERVICIO = ? "
					+ " ORDER BY e.NOMBRE ASC ";
			
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++,idTipoServicio );
			// Performing operation
			rs = stmt.executeQuery();
		
		empleado = new ArrayList<EmpleadoDTO>();
		EmpleadoDTO e = null;

			while (rs.next()) {				
				e = loadNextDTO(rs);
				empleado.add(e);
			}			

		} catch (SQLException e) {			
			logger.error(idTipoServicio, e);
			throw new DataException(""+idTipoServicio, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}	
		
		return  empleado;
	}
	@Override
	public  int update(Connection c, Empleado empleado) throws DataException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int updatedRows = 0;
		try {
			
			String sql= " UPDATE EMPLEADO SET "
					+ " NOMBRE = ?, "
					+ " APELLIDO1 = ?, "
					+ " APELLIDO2 = ?, "
					+ " NIF = ?, "
					+ " TLF = ?, "
					+ " EMAIL = ?, "
					+ " PASSWORD_ENCRYPTED = ?, "
					+ " DOMICILIO = ?, "
					+ " ID_TIPO_EMPLEADO = ?, "
					+ " ID_LOCALIDAD = ?"
					+ " WHERE ID = ? ";
			
		stmt = c.prepareStatement(sql);
		int i = 1;
		JDBCUtils.setParameterSinUpper(stmt, i++, empleado.getNombre());
		JDBCUtils.setParameterSinUpper(stmt, i++, empleado.getApellido1());
		JDBCUtils.setParameterSinUpper(stmt, i++, empleado.getApellido2());
		JDBCUtils.setParameterSinUpper(stmt, i++, empleado.getNif());
		JDBCUtils.setParameterSinUpper(stmt, i++, empleado.getTlf());
		JDBCUtils.setParameterSinUpper(stmt, i++, empleado.getEmail());
		JDBCUtils.setParameterSinUpper(stmt, i++, empleado.getPassword());
		JDBCUtils.setParameterSinUpper(stmt, i++, empleado.getDomicilio());
		JDBCUtils.setParameter(stmt, i++, empleado.getIdTipoEmpleado());
		JDBCUtils.setParameter(stmt, i++, empleado.getIdLocalidad());
		JDBCUtils.setParameter(stmt, i++, empleado.getId());
		updatedRows = stmt.executeUpdate();
		if (updatedRows!=1) {
			throw new DataException(empleado.getEmail()+"");
		}
		
	}catch (SQLException e) {			
		logger.error(empleado, e);
		throw new DataException(""+empleado.getEmail(), e);
	} finally {
		JDBCUtils.closeResultSet(rs);
		JDBCUtils.closePreparedStatement(stmt);
	}
	return updatedRows;
}
	
	private static EmpleadoDTO loadNextDTO(ResultSet rs)
			throws SQLException{
		EmpleadoDTO e = new EmpleadoDTO();

		int i = 1;
		e.setId(rs.getInt(i++));
		e.setNombre(rs.getString(i++));
		e.setApellido1(rs.getString(i++));
		e.setApellido2(rs.getString(i++));
		e.setNif(rs.getString(i++));
		e.setTlf(rs.getString(i++));
		e.setEmail(rs.getString(i++));
		e.setPassword(rs.getString(i++));
		e.setDomicilio(rs.getString(i++));
		e.setIdTipoEmpleado(rs.getInt(i++));
		e.setNombreTipoEmpleado(rs.getString(i++));
		e.setIdLocalidad(rs.getInt(i++));
		e.setNombreLocalidad(rs.getString(i++));
		
		return e;	
	}
			
}
