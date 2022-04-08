package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.AsistidoFamiliarDAO;
import com.bruno.adsaude.dao.impl.AsistidoFamiliarDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.AsistidoFamiliar;
import com.bruno.adsaude.service.AsistidoFamiliarService;

public class AsistidoFamiliarServiceImpl implements AsistidoFamiliarService{

	private static Logger logger = LogManager.getLogger(AsistidoFamiliarServiceImpl.class);
	private AsistidoFamiliarDAO asistidoFamiliarDAO = null;
	
	public AsistidoFamiliarServiceImpl() {
		asistidoFamiliarDAO = new AsistidoFamiliarDAOImpl();
	}
	
	@Override
	public void create(AsistidoFamiliar asistidof) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();								
			
			c.setAutoCommit(false);

			asistidoFamiliarDAO.create(c, asistidof);		

			commitOrRollback = true;
			
		} catch (SQLException e) {
			logger.error(asistidof, e);
			throw new DataException(e);			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
	}


	@Override
	public void delete(int idAsistido, int idFamiliar) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();								
			
			c.setAutoCommit(false);

			asistidoFamiliarDAO.delete(c, idAsistido, idFamiliar);		

			commitOrRollback = true;
			
		} catch (SQLException e) {
			logger.error(idAsistido, e);
			throw new DataException(e);			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
	}

}
