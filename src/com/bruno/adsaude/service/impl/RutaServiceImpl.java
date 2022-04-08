package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.RutaDAO;
import com.bruno.adsaude.dao.impl.RutaDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.RutaDTO;
import com.bruno.adsaude.service.RutaService;

public class RutaServiceImpl implements RutaService{
	
	private static Logger logger = LogManager.getLogger(RutaServiceImpl.class);
	private RutaDAO rutaDAO = null;
	
	public RutaServiceImpl() {
		rutaDAO = new RutaDAOImpl();
	}

	@Override
	public List<RutaDTO> findByEmpleado(int idEmpleado) throws DataException, ServiceException {
		Connection c = null;
		List<RutaDTO> ruta = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			ruta = rutaDAO.findByEmpleado(c, idEmpleado);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idEmpleado, sqle);
			throw new ServiceException(idEmpleado+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idEmpleado, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(idEmpleado, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return ruta;
	}

	@Override
	public List<RutaDTO> findByAsistido(int idAsistido) throws DataException, ServiceException {
		Connection c = null;
		List<RutaDTO> ruta = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			ruta = rutaDAO.findByAsistido(c, idAsistido);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idAsistido, sqle);
			throw new ServiceException(idAsistido+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idAsistido, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(idAsistido, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return ruta;
	}

}
