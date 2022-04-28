package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.IncidenciaDAO;
import com.bruno.adsaude.dao.impl.IncidenciaDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Incidencia;
import com.bruno.adsaude.model.IncidenciaDTO;
import com.bruno.adsaude.model.TipoIncidencia;
import com.bruno.adsaude.service.IncidenciaService;

public class IncidenciaServiceImpl implements IncidenciaService {
	
	private static Logger logger = LogManager.getLogger(IncidenciaServiceImpl.class);
	private IncidenciaDAO incidenciaDAO=null;
	
	public IncidenciaServiceImpl() {
		incidenciaDAO = new IncidenciaDAOImpl();
	}

	@Override
	public List<IncidenciaDTO> findByDate(Date fechaDesde, Date fechaHasta) throws DataException, ServiceException {
		Connection c = null;
		List<IncidenciaDTO> incidencia = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			incidencia = incidenciaDAO.findByDate(c, fechaDesde, fechaHasta);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(fechaDesde, sqle);
			throw new ServiceException(fechaDesde+""+fechaHasta+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(fechaDesde, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(fechaDesde, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return incidencia;
	}

	@Override
	public List<IncidenciaDTO> findByAsistidoAfectado(int id) throws DataException, ServiceException {
		Connection c = null;
		List<IncidenciaDTO> incidencia = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			incidencia = incidenciaDAO.findByAsistidoAfectado(c, id);
								
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
		return incidencia;
	}

	@Override
	public List<IncidenciaDTO> findByCreador(Integer idasistido, Integer idfamiliar, Integer idempleado)
			throws DataException, ServiceException {
		Connection c = null;
		List<IncidenciaDTO> incidencia = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			incidencia = incidenciaDAO.findByCreador(c, idasistido, idfamiliar, idempleado);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idasistido, sqle);
			throw new ServiceException(idasistido+""+idfamiliar+""+idempleado, sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idasistido, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(idasistido, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return incidencia;
	}

	@Override
	public  Incidencia create(Incidencia incidencia) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		Incidencia incidenciaCreated = null;
		try {
			c = ConnectionManager.getConnection();								
			
			c.setAutoCommit(false);
			// Estado por defecto al crearla
			incidencia.setIdTipoEstadoIncidencia(TipoIncidencia.ENVIADA);
			
			incidenciaCreated = incidenciaDAO.create(c, incidencia);	
			
			
			commitOrRollback = true;
		}catch (SQLException e) {
			logger.error(incidencia, e);
			throw new DataException(e);	
		}finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return incidenciaCreated;
	}

}
