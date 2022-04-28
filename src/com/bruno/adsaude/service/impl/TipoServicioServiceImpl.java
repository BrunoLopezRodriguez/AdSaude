package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.TipoServicioDAO;
import com.bruno.adsaude.dao.impl.TipoServicioDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.TipoServicio;
import com.bruno.adsaude.model.TipoServicioDTO;
import com.bruno.adsaude.service.TipoServicioService;

public class TipoServicioServiceImpl implements TipoServicioService{

	private static Logger logger = LogManager.getLogger(TipoServicioServiceImpl.class);
	private TipoServicioDAO tipoServicioDAO = null;
	
	public TipoServicioServiceImpl() {
		tipoServicioDAO = new TipoServicioDAOImpl();
	}
	
	@Override
	public TipoServicio findById(Integer id) throws DataException, ServiceException {
		Connection c = null;
		TipoServicio tipoServicio = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			tipoServicio = tipoServicioDAO.findById(c, id);
			
									
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(id, sqle);
			throw new ServiceException(id+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(id, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(id, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return tipoServicio;		
	}

	
	@Override
	public List<TipoServicio> findBy() throws DataException, ServiceException {
		Connection c = null;
		List<TipoServicio> tipoServicio = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			tipoServicio = tipoServicioDAO.findBy(c);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error("Findall", sqle);
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
		return tipoServicio;
	}

	@Override
	public List<TipoServicio> findByPadre() throws DataException, ServiceException {
		Connection c = null;
		List<TipoServicio> tipoServicio = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			tipoServicio = tipoServicioDAO.findByPadre(c);
								
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
		return tipoServicio;
	}

	@Override
	public List<TipoServicioDTO> findByHijas() throws DataException, ServiceException {
		Connection c = null;
		List<TipoServicioDTO> tipoServicio = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			tipoServicio = tipoServicioDAO.findByHijas(c);
								
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
		return tipoServicio;
	}

	@Override
	public List<TipoServicio> findByPadreId(int idPadre) throws DataException, ServiceException {
		Connection c = null;
		List<TipoServicio> tipoServicio = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			tipoServicio = tipoServicioDAO.findByPadreId(c, idPadre);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idPadre, sqle);
			throw new ServiceException(idPadre+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idPadre, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(idPadre, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return tipoServicio;
	}

}
