package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.ProvinciaDAO;
import com.bruno.adsaude.dao.impl.ProvinciaDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Provincia;
import com.bruno.adsaude.service.ProvinciaService;

public class ProvinciaServiceImpl implements ProvinciaService{

	private static Logger logger = LogManager.getLogger(ProvinciaServiceImpl.class);
	private ProvinciaDAO provinciaDAO=null;
	
	public ProvinciaServiceImpl() {
		provinciaDAO = new ProvinciaDAOImpl();
	}
	
	@Override
	public List<Provincia> findByPais(int idPais) throws DataException, ServiceException {
		Connection c = null;
		List<Provincia> provincia = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			provincia = provinciaDAO.findByPais(c, idPais);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idPais, sqle);
			throw new ServiceException(idPais+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idPais, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(idPais, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return provincia;
	}

}
