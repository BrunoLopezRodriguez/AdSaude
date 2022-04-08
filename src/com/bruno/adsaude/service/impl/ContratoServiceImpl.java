package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.ContratoDAO;
import com.bruno.adsaude.dao.ContratoTipoServicioDAO;
import com.bruno.adsaude.dao.impl.ContratoDAOImpl;
import com.bruno.adsaude.dao.impl.ContratoTipoServicioDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Contrato;
import com.bruno.adsaude.model.ContratoDTO;
import com.bruno.adsaude.model.ContratoTipoServicio;
import com.bruno.adsaude.service.ContratoService;

public class ContratoServiceImpl implements ContratoService{
	
	private static Logger logger = LogManager.getLogger(ContratoServiceImpl.class);
	private ContratoDAO contratoDAO = null;
	private ContratoTipoServicioDAO contratoTipoServicioDAO = null;
	
	public ContratoServiceImpl() {
		contratoDAO = new ContratoDAOImpl();
		contratoTipoServicioDAO = new ContratoTipoServicioDAOImpl();
	}

	@Override
	public ContratoDTO findByAsistido(int idAsistido) throws DataException, ServiceException {
		Connection c = null;
		ContratoDTO contrato = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			contrato = contratoDAO.findByAsistido(c, idAsistido);
								
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
		return contrato;	
	}

	@Override
	public Integer create(Contrato contrato, List<ContratoTipoServicio> contratoTS) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		Integer contratoId = null;
		try  {
			c = ConnectionManager.getConnection();								
			
			c.setAutoCommit(false);

			//añadir creacion de ContatoTipoServicio
			contratoId = contratoDAO.create(c, contrato);		
			
			for (ContratoTipoServicio cts : contratoTS) {	
				cts.setIdContrato(contratoId);
			}
			contratoTipoServicioDAO.create(c, contratoTS);
			
			commitOrRollback = true;
			
		} catch (SQLException e) {
			logger.error(contratoTS, e);
			throw new DataException(e);			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		
		return contratoId;
	}

}
