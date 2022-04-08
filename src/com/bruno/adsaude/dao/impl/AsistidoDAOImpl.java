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

import com.bruno.adsaude.dao.AsistidoDAO;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.Asistido;
import com.bruno.adsaude.model.AsistidoDTO;


public class AsistidoDAOImpl implements AsistidoDAO {

	StringBuilder sb= new StringBuilder(" ");
	private static Logger logger = LogManager.getLogger(AsistidoDAOImpl.class);
	
	public AsistidoDAOImpl () {
		
	}
	@Override
	public  Asistido findById(Connection c, int id) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Asistido asistido = null;
		try {
									
			String sql = "SELECT a.ID, a.NOMBRE, a.APELLIDO1, a.APELLIDO2, a.NIF, a.TLF, a.EMAIL, a.PASSWORD_ENCRYPTED, a.DOMICILIO, a.ID_MEDICO, "
					+ " a.ID_LOCALIDAD " 
					+ " FROM asistido a "
					+ " WHERE a.ID= ? ";
			// Create prepared statement
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, id);
			// Performing operation
	
			
			rs = stmt.executeQuery();					
			while (rs.next()) {				
				asistido = loadNext(rs);										
			}	
			
		} catch (SQLException e) {			
			logger.error(id, e);
			throw new DataException(sb.append(id).toString(), e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  asistido;
	}
	@Override
	public  AsistidoDTO findByEmail(Connection c, String email) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AsistidoDTO asistido = null;
		try {
			// Crea0ting statement
			String sql= "SELECT a.ID, a.NOMBRE, a.APELLIDO1, a.APELLIDO2, a.NIF, a.TLF, a.EMAIL, a.PASSWORD_ENCRYPTED, a.DOMICILIO,"
					+ " a.ID_MEDICO, m.NOMBRE, a.ID_LOCALIDAD, l.NOMBRE"
					+ " FROM ASISTIDO a"
					+ " INNER JOIN LOCALIDAD l"
					+ " ON a.ID_LOCALIDAD=l.ID"
					+ " INNER JOIN MEDICO m"
					+ " ON m.ID=a.ID_MEDICO"
					+ " WHERE UPPER(a.EMAIL) = ?";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, email);
			// Performing operation
			rs = stmt.executeQuery();			
			AsistidoDTO a=null;
			while (rs.next()) {				
				a = loadNextDTO(rs);								
				asistido=a;										
			}						
		} catch (SQLException e) {			
			logger.error(email, e);
			throw new DataException(email, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}			
		return asistido;
	}
		
	@Override
	public  List<AsistidoDTO> findByFamiliar (Connection c, int idFamiliar) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AsistidoDTO> asistido = null;
		try {
			// Creating statement
			String sql= "SELECT a.ID, a.NOMBRE, a.APELLIDO1, a.APELLIDO2, a.NIF, a.TLF, a.EMAIL, a.PASSWORD_ENCRYPTED, "
					+ " a.DOMICILIO, a.ID_MEDICO, m.NOMBRE, a.ID_LOCALIDAD, l.NOMBRE "
					+ " FROM ASISTIDO a "
					+ " INNER JOIN LOCALIDAD l "
					+ " ON a.ID_LOCALIDAD=l.ID "
					+ " INNER JOIN MEDICO m "
					+ " ON m.ID=a.ID_MEDICO "
					+ " INNER JOIN ASISTIDO_FAMILIAR af "
					+ " ON af.ID_ASISTIDO=a.ID "
					+ " WHERE af.ID_FAMILIAR = ? "
					+ " ORDER BY a.NOMBRE ASC ";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, idFamiliar);
			// Performing operation
			rs = stmt.executeQuery();		
			asistido = new ArrayList <AsistidoDTO>();
			AsistidoDTO a=null;
			while (rs.next()) {				
				a = loadNextDTO(rs);								
				asistido.add(a);										
			}			
			
		} catch (SQLException e) {			
			logger.error(idFamiliar, e);
			throw new DataException(""+idFamiliar, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  asistido;
	}
	
	
	@Override
	public  AsistidoDTO findByDni (Connection c, String dni) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AsistidoDTO asistido = null;
		try {
			// Creating statement
			String sql= "SELECT a.NOMBRE, a.APELLIDO1, a.APELLIDO2, a.NIF, a.DOMICILIO " 
					+ " FROM ASISTIDO a "
					+ " WHERE Upper(a.NIF) LIKE upper(%?%) ";
			// Create prepared statement
						stmt = c.prepareStatement(sql);
						int i;
						i=1;
						JDBCUtils.setParameter(stmt, i++, dni);
						// Performing operation
				
						
						rs = stmt.executeQuery();					
						while (rs.next()) {				
							asistido = loadNextDTO(rs);										
						}	
						
					} catch (SQLException e) {			
						logger.error(dni, e);
						throw new DataException(sb.append(dni).toString(), e);
					} finally {
						JDBCUtils.closeResultSet(rs);
						JDBCUtils.closePreparedStatement(stmt);	
					}	
					
					return  asistido;
				}
	
	
	
	@Override
	public  List<AsistidoDTO> findByRuta (Connection c, int idRuta) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AsistidoDTO> asistido = null;
		try {
			// Establishing the connection with data source
			c = ConnectionManager.getConnection();
			// Creating statement
			String sql= "SELECT a.ID, a.NOMBRE, a.APELLIDO1, a.APELLIDO2, a.NIF, a.TLF, a.EMAIL, a.PASSWORD_ENCRYPTED,"
					+ " a.DOMICILIO, a.ID_MEDICO, m.NOMBRE, a.ID_LOCALIDAD, l.NOMBRE"
					+ " FROM ASISTIDO a"
					+ " INNER JOIN LOCALIDAD l"
					+ " ON a.ID_LOCALIDAD=l.ID"
					+ " INNER JOIN MEDICO m"
					+ " ON m.ID=a.ID_MEDICO"
					+ " INNER JOIN RUTA_ASISTIDO ra"
					+ " ON ra.ID_ASISTIDO=a.ID"
					+ " WHERE ra.ID_RUTA = ? "
					+ " ORDER BY a.NOMBRE ASC ";
			stmt = c.prepareStatement(sql);
			int i;
			i=1;
			JDBCUtils.setParameter(stmt, i++, idRuta);
			// Performing operation
			rs = stmt.executeQuery();				
			asistido = new ArrayList <AsistidoDTO>();
			AsistidoDTO a=null;
			while (rs.next()) {				
				a = loadNextDTO(rs);		
				asistido.add(a);										
			}					
		} catch (SQLException e) {			
			logger.error(idRuta, e);
			throw new DataException(""+idRuta, e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);	
		}	
		
		return  asistido;
	}
	@Override
	public  Integer create (Connection c, Asistido asistido) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql= " INSERT INTO ASISTIDO (NOMBRE, APELLIDO1, APELLIDO2, NIF, TLF , EMAIL,"
					+ " PASSWORD_ENCRYPTED, DOMICILIO, ID_MEDICO, ID_LOCALIDAD) VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int i=1;
			JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getNombre());
			JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getApellido1());
			JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getApellido2());
			JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getNif());
			JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getTlf());
			JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getEmail());
			JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getPassword());
			JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getDomicilio());
			JDBCUtils.setParameter(stmt, i++, asistido.getIdMedico());
			JDBCUtils.setParameter(stmt, i++, asistido.getIdLocalidad());
			
			int insertedRows = stmt.executeUpdate();
			if (insertedRows ==1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					asistido.setId(rs.getInt(1));
					
				}
			}
			else {
				throw new DataException(asistido.getNombre());
			}
		} catch (SQLException e) {
			logger.error(asistido, e);
			throw new DataException(asistido.getEmail(), e);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closePreparedStatement(stmt);
		}
		return asistido.getId();
	}
	
	@Override
	public void update(Connection c, Asistido asistido) throws DataException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int updatedRows = 0;
		try {	
			
			String sql= " UPDATE ASISTIDO SET "
					+ " NOMBRE = ?, "
					+ " APELLIDO1 = ?, "
					+ " APELLIDO2 = ?, "
					+ " NIF = ?, "
					+ " TLF = ?, "
					+ " EMAIL = ?, "
					+ " PASSWORD_ENCRYPTED = ?, "
					+ " DOMICILIO = ?, "
					+ " ID_MEDICO = ?, "
					+ " ID_LOCALIDAD = ?"
					+ " WHERE ID = ? ";
			
		stmt = c.prepareStatement(sql);
		int i = 1;
		JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getNombre());
		JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getApellido1());
		JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getApellido2());
		JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getNif());
		JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getTlf());
		JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getEmail());
		JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getPassword());
		JDBCUtils.setParameterSinUpper(stmt, i++, asistido.getDomicilio());
		JDBCUtils.setParameter(stmt, i++, asistido.getIdMedico());
		JDBCUtils.setParameter(stmt, i++, asistido.getIdLocalidad());
		JDBCUtils.setParameter(stmt, i++, asistido.getId());
		updatedRows = stmt.executeUpdate();
		if (updatedRows!=1) {
			throw new DataException(asistido.getNombre());
		}
		
		
	}catch (SQLException e) {			
		logger.error(asistido, e);
		throw new DataException(asistido.getNombre(), e);
	} finally {
		JDBCUtils.closeResultSet(rs);
		JDBCUtils.closePreparedStatement(stmt);
	}
}
	
	private static AsistidoDTO loadNextDTO(ResultSet rs)
			throws SQLException{
		AsistidoDTO a = new AsistidoDTO();

		int i = 1;
		a.setId(rs.getInt(i++));
		a.setNombre(rs.getString(i++));
		a.setApellido1(rs.getString(i++));
		a.setApellido2(rs.getString(i++));
		a.setNif(rs.getString(i++));
		a.setTlf(rs.getString(i++));
		a.setEmail(rs.getString(i++));
		a.setPassword(rs.getString(i++));
		a.setDomicilio(rs.getString(i++));
		a.setIdMedico(rs.getInt(i++));
		a.setNombreMedico(rs.getString(i++));
		a.setIdLocalidad(rs.getInt(i++));
		a.setNombreLocalidad(rs.getString(i++));
		
		return a;	
	}
	private static Asistido loadNext(ResultSet rs)
			throws SQLException{
		Asistido a = new Asistido();

		int i = 1;
		a.setId(rs.getInt(i++));
		a.setNombre(rs.getString(i++));
		a.setApellido1(rs.getString(i++));
		a.setApellido2(rs.getString(i++));
		a.setNif(rs.getString(i++));
		a.setTlf(rs.getString(i++));
		a.setEmail(rs.getString(i++));
		a.setPassword(rs.getString(i++));
		a.setDomicilio(rs.getString(i++));
		a.setIdMedico(rs.getInt(i++));
		a.setIdLocalidad(rs.getInt(i++));
		
		return a;	
	}
}