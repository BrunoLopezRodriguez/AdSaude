package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.AsistenciaDAO;
import com.bruno.adsaude.dao.impl.AsistenciaDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.AsistenciaCriteria;
import com.bruno.adsaude.model.AsistenciaDTO;
import com.bruno.adsaude.model.Results;
import com.bruno.adsaude.service.AsistenciaService;

public class AsistenciaServiceImpl implements AsistenciaService{
	
	private AsistenciaDAO asistenciaDAO = null;
	private static Logger logger = LogManager.getLogger(AsistenciaServiceImpl.class);
	
	public AsistenciaServiceImpl() {
		asistenciaDAO = new AsistenciaDAOImpl();
	}

	@Override
	public Results<AsistenciaDTO> findByCriteria(AsistenciaCriteria cr,  int startIndex, int pageSize) throws DataException, ServiceException {
		Connection c = null;
		Results<AsistenciaDTO> results = new Results<AsistenciaDTO>();
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			results = asistenciaDAO.findByCriteria(c, cr, startIndex, pageSize);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(cr, sqle);
			throw new ServiceException(cr.getIdAsistido()+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(cr, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(cr, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return results;
	}

	
}
