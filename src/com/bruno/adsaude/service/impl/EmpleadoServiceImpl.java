package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.EmpleadoDAO;
import com.bruno.adsaude.dao.impl.EmpleadoDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.Empleado;
import com.bruno.adsaude.model.EmpleadoDTO;
import com.bruno.adsaude.service.EmpleadoService;
import com.bruno.adsaude.service.util.PasswordEncryptionUtil;

public class EmpleadoServiceImpl implements EmpleadoService{
	
	private static Logger logger = LogManager.getLogger(EmpleadoServiceImpl.class);
	private EmpleadoDAO empleadoDAO=null;
	
	public EmpleadoServiceImpl() {
		empleadoDAO = new EmpleadoDAOImpl();
	}

	@Override
	public EmpleadoDTO login(String email, String password) throws DataException, ServiceException {
		Connection c = null;
		EmpleadoDTO empleado = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			empleado = empleadoDAO.findByEmail(c, email);
			
			if (empleado!=null) {
				boolean passwordOK = PasswordEncryptionUtil.checkPassword(password, empleado.getPassword());
				if (!passwordOK) {
					empleado = null;
				}
			}
									
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(email, sqle);
			throw new ServiceException(email, sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(email, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(email, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return empleado;	
	}
	
	@Override
	public EmpleadoDTO findByEmail(String email) throws DataException, ServiceException {
		Connection c = null;
		EmpleadoDTO empleado = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			empleado = empleadoDAO.findByEmail(c, email);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(email, sqle);
			throw new ServiceException(email+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(email, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(email, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return empleado;	
	}

	@Override
	public List<EmpleadoDTO> findByServicio(int idTipoServicio) throws DataException, ServiceException {
		Connection c = null;
		List<EmpleadoDTO> empleado = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			empleado = empleadoDAO.findByServicio(c, idTipoServicio);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idTipoServicio, sqle);
			throw new ServiceException(idTipoServicio+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idTipoServicio, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(idTipoServicio, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return empleado;	
	}

	@Override
	public int update(Empleado empleado) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		String password =null;
		Integer updatedrows=0;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			
			
			if (empleado!=null) {
				password= PasswordEncryptionUtil.encryptPassword(empleado.getPassword());
				empleado.setPassword(password);
				updatedrows = empleadoDAO.update(c, empleado);
			}
			
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(empleado, sqle);
			throw new ServiceException(empleado.getEmail()+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(empleado, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(empleado, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return updatedrows;
	}

}
