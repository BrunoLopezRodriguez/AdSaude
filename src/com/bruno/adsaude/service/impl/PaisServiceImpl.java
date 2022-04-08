package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.PaisDAO;
import com.bruno.adsaude.dao.impl.PaisDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Pais;
import com.bruno.adsaude.service.PaisService;

public class PaisServiceImpl implements PaisService{
	
	private static Logger logger = LogManager.getLogger(PaisServiceImpl.class);
	private PaisDAO paisDAO=null;
	
	public PaisServiceImpl() {
		paisDAO = new PaisDAOImpl();
	}
	@Override
	public List<Pais> findBy() throws DataException, ServiceException {
		Connection c = null;
		List<Pais> pais = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			pais = paisDAO.findBy(c);
								
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
		return pais;
	}

}
