package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.FamiliarDAO;
import com.bruno.adsaude.dao.impl.FamiliarDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.exception.UserAlreadyExistsException;
import com.bruno.adsaude.model.Familiar;
import com.bruno.adsaude.model.FamiliarDTO;
import com.bruno.adsaude.service.FamiliarService;
import com.bruno.adsaude.service.MailService;
import com.bruno.adsaude.service.util.PasswordEncryptionUtil;

public class FamiliarServiceImpl implements FamiliarService{
	
	private static Logger logger = LogManager.getLogger(FamiliarServiceImpl.class);
	private FamiliarDAO familiarDAO=null;
	private MailService mailService= null;
	
	public FamiliarServiceImpl() {
		familiarDAO = new FamiliarDAOImpl();
		mailService = new MailServiceImpl();
	}

	@Override
	public List<FamiliarDTO> findByAsistido(int id) throws DataException, ServiceException {
		Connection c = null;
		List<FamiliarDTO> familiar = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			familiar = familiarDAO.findByAsistido(c, id);
								
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
		return familiar;
	}

	@Override
	public FamiliarDTO findByDni(String dni) throws DataException, ServiceException {
		Connection c = null;
		FamiliarDTO familiar = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			familiar = familiarDAO.findByDni(c, dni);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(dni, sqle);
			throw new ServiceException(dni+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(dni, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(dni, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return familiar;	
	}
	
	@Override
	public FamiliarDTO findByEmail(String email) throws DataException, ServiceException {
		Connection c = null;
		FamiliarDTO familiar = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			familiar = familiarDAO.findByEmail(c, email);
								
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
		return familiar;	
	}
	
	
	@Override
	public FamiliarDTO login(String email, String password) throws DataException, ServiceException {
		Connection c = null;
		FamiliarDTO familiar = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			familiar = familiarDAO.findByEmail(c, email);
			
			if (familiar!=null) {
				boolean passwordOK = PasswordEncryptionUtil.checkPassword(password, familiar.getPassword());
				if (!passwordOK) {
					familiar = null;
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
		return familiar;	
	}

	@Override
	public Integer create(Familiar familiar) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		Integer userId = null;
		try  {
			c = ConnectionManager.getConnection();								
			
			c.setAutoCommit(false);

			if (familiarDAO.findByEmail(c, familiar.getEmail())!=null) {
				throw new UserAlreadyExistsException(familiar.getEmail());				
			}
			
			userId = familiarDAO.create(c, familiar);		

			mailService.sendPlain("no-reply@gmail.com", 
					"Bienvenido a AdSaude...", 
					"Hola "+familiar.getNombre()+", Bien...", 
					familiar.getEmail());
			
			commitOrRollback = true;
			
		} catch (SQLException e) {
			logger.error(familiar, e);
			throw new DataException(e);			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		
		return userId;
	}

	@Override
	public int update(Familiar familiar) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		String password =null;
		Integer updatedRows=0;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			if (familiar!=null) {
				if(familiar.getPasswordEncriptada()!=null) {
					familiar.setPassword(familiar.getPasswordEncriptada());
				}else {
				password= PasswordEncryptionUtil.encryptPassword(familiar.getPassword());
				familiar.setPassword(password);
				updatedRows =	familiarDAO.update(c, familiar);
				}
			}
			
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(familiar, sqle);
			throw new ServiceException(familiar.getEmail()+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(familiar, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(familiar, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return updatedRows;
	}
	

}
