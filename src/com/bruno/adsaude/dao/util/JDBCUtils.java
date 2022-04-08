package com.bruno.adsaude.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.model.AsistenciaCriteria;

public class JDBCUtils {
	
	private static Logger logger = LogManager.getLogger(JDBCUtils.class);
	
	public static final String queryCreator(AsistenciaCriteria ac) {
		StringBuilder sql = new StringBuilder();
		Boolean primero = false;
		if(ac.getFechaHoraInicio()!=null) {
			if(primero == false) {
				primero = true;
				sql.append("WHERE a.FECHA_HORA_INICIO > ? ");
			}else if (primero == true) {
				sql.append("AND a.FECHA_HORA_INICIO > ? ");
			}
		}	
		if(ac.getFechaHoraFin()!=null) {
			if(primero == false) {
				primero = true;
				sql.append("WHERE a.FECHA_HORA_INICIO  < ? ");
			}else if (primero == true) {
				sql.append("AND a.FECHA_HORA_INICIO < ? ");
			}
		}
		if(ac.getIdAsistido()!=null) {
			if(primero == false) {
				primero = true;
				sql.append("WHERE a.ID_ASISTIDO = ? ");
			}else if (primero == true) {
				sql.append("AND a.ID_ASISTIDO = ? ");
			}
		}
		if (ac.getIdServicio() != null) {
			if(primero == false) {
				primero = true;
				sql.append("WHERE a.ID_TIPO_SERVICIO = ? ");
			}else if (primero == true) {
				sql.append("AND a.ID_TIPO_SERVICIO = ? ");
			}
		}
		if(ac.getIdEmpleado() != null) {
			if(primero == false) {
				primero = true;
				sql.append("WHERE a.ID_EMPLEADO = ? ");
			}else if (primero == true) {
				sql.append("AND a.ID_EMPLEADO = ? ");
			}
		}
		sql.append(" ORDER BY FECHA_HORA_INICIO ;");
		primero = false;
		return sql.toString();
	}
	
	public static final void setParameter(PreparedStatement ps, int parameterIndex, Long value) 
			throws SQLException {		
		setParameter(ps, parameterIndex, value, false);
	}
	
	public static final void setParameter(PreparedStatement ps, int parameterIndex, Long value, boolean nullable) 
			throws SQLException {
		if (value!=null) {
			ps.setLong(parameterIndex, value);		
		} else {
			if (nullable) {
				ps.setNull(parameterIndex, Types.INTEGER);
			} 
		}
	}
	
	
	public static final void setParameter(PreparedStatement ps, int parameterIndex, Integer value) 
			throws SQLException {		
		if (value!=null) {
			setParameter(ps, parameterIndex, value, false);
		}
	}
	public static final void setParameter(PreparedStatement ps, int parameterIndex, Integer value, boolean nullable) 
			throws SQLException {
		if (value!=null) {
			ps.setInt(parameterIndex, value);		
		} else {
			if (nullable) {
				ps.setNull(parameterIndex, Types.INTEGER);
			} 
		}
	}

	public static void setParameter(PreparedStatement stmt, int parameterIndex, String value) 
		throws SQLException {		
			if (value!=null) {
				setParameter(stmt, parameterIndex, value, false);
			}
		}
	
	public static final void setParameter(PreparedStatement ps, int parameterIndex, String value, boolean nullable) 
			throws SQLException {
		if (value!=null) {
			ps.setString(parameterIndex, value.toUpperCase());		
		} else {
			if (nullable) {
				ps.setNull(parameterIndex, Types.VARCHAR);
			} 
		}
	}
	
	public static void setParameterSinUpper(PreparedStatement stmt, int parameterIndex, String value) 
			throws SQLException {		
				if (value!=null) {
					setParameterSinUpper(stmt, parameterIndex, value, false);
				}
			}
	
	public static final void setParameterSinUpper(PreparedStatement ps, int parameterIndex, String value, boolean nullable) 
			throws SQLException {
		if (value!=null) {
			ps.setString(parameterIndex, value);		
		} else {
			if (nullable) {
				ps.setNull(parameterIndex, Types.VARCHAR);
			} 
		}
	}
	
	
	public static void setParameter(PreparedStatement stmt, int parameterIndex, Date value) 
		throws SQLException{
			if (value!=null) {
				stmt.setDate(parameterIndex, new java.sql.Date(value.getTime()));
			
		}
		
	}

	public static final void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	
	public static final void closePreparedStatement (PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {					
				logger.error(e);
			}
		}	
	}
	
	/**
	 * Metodo de finalizacion de transaccion <b>para el caso de autocommit = false</b>
	 * y de cierre de conexion.
	 *  
	 * Ejecuta commit() o rollback() y a continuacion cierra la conexi�n.
	 *  
	 * @param connection Conexion a cerrar.
	 * @param commitOrRollback Si es true ejecuta commit() y en caso contrario ejecuta rollback().
	 */
	public static void closeConnection(Connection connection, boolean commitOrRollback)
		throws DataException {
        try {
            if (connection != null) {
                if (commitOrRollback) {
                	connection.commit();
                } else {
                	connection.rollback();                        
                }
                connection.close();
            }
        } catch (SQLException e) {
            throw new DataException(e);
        }
	}
	
}
