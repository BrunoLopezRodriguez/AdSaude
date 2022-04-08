package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.LocalidadDAO;
import com.bruno.adsaude.dao.impl.LocalidadDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Localidad;
import com.bruno.adsaude.service.LocalidadService;

public class LocalidadServiceImpl implements LocalidadService{

	private static Logger logger = LogManager.getLogger(LocalidadServiceImpl.class);
	private LocalidadDAO localidadDAO = null;
	
	public LocalidadServiceImpl() {
		localidadDAO = new LocalidadDAOImpl();
	}
	@Override
	public List<Localidad> findByProvincia(int idProvincia) throws DataException, ServiceException {
		Connection c = null;
		List<Localidad> localidad = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			localidad = localidadDAO.findByProvincia(c, idProvincia);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idProvincia, sqle);
			throw new ServiceException(idProvincia+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idProvincia, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(idProvincia, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return localidad;
	}

}
