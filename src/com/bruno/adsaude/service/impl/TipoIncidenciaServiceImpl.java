package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.TipoIncidenciaDAO;
import com.bruno.adsaude.dao.impl.TipoIncidenciaDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.TipoIncidencia;
import com.bruno.adsaude.service.TipoIncidenciaService;

public class TipoIncidenciaServiceImpl implements TipoIncidenciaService{

	private static Logger logger = LogManager.getLogger(TipoIncidenciaServiceImpl.class);
	private TipoIncidenciaDAO tipoIncidenciaDAO = null;
	
	public TipoIncidenciaServiceImpl() {
		tipoIncidenciaDAO = new TipoIncidenciaDAOImpl();
	}
	
	@Override
	public List<TipoIncidencia> findBy() throws DataException, ServiceException {
		Connection c = null;
		List<TipoIncidencia> tipoIncidencia = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			tipoIncidencia = tipoIncidenciaDAO.findBy(c);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error("FindAll", sqle);
			throw new ServiceException("Error FindAll", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error("FindAll", de);	
			throw de;
			
		} catch (Exception e) {
			logger.error("FindAll", e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return tipoIncidencia;
	}

}
