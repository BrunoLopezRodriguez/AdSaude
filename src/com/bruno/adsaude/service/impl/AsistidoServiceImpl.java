package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.AsistidoDAO;
import com.bruno.adsaude.dao.impl.AsistidoDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.exception.UserAlreadyExistsException;
import com.bruno.adsaude.model.Asistido;
import com.bruno.adsaude.model.AsistidoDTO;
import com.bruno.adsaude.service.AsistidoService;
import com.bruno.adsaude.service.MailService;
import com.bruno.adsaude.service.util.PasswordEncryptionUtil;

public class AsistidoServiceImpl implements AsistidoService {

	private static Logger logger = LogManager.getLogger(AsistidoServiceImpl.class);
	private AsistidoDAO asistidoDAO = null;
	private MailService mailService= null;
	
	public AsistidoServiceImpl() {
		asistidoDAO = new AsistidoDAOImpl();
		mailService = new MailServiceImpl();
	}

	@Override
	public AsistidoDTO login(String email, String password) throws DataException, ServiceException {
		Connection c = null;
		AsistidoDTO asistido = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			asistido = asistidoDAO.findByEmail(c, email);
			
			if (asistido!=null) {
				boolean passwordOK = PasswordEncryptionUtil.checkPassword(password, asistido.getPassword());
				if (!passwordOK) {
					asistido = null;
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
		return asistido;		
	}

	@Override
	public List<AsistidoDTO> findByFamiliar(int idFamiliar) throws DataException, ServiceException {
		Connection c = null;
		List<AsistidoDTO> asistido = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			asistido = asistidoDAO.findByFamiliar(c, idFamiliar);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idFamiliar, sqle);
			throw new ServiceException(idFamiliar+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idFamiliar, de);	
			throw de;
			
		} catch (Exception e) {
			logger.error(idFamiliar, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return asistido;	
	}

	
	@Override
	public AsistidoDTO findByDni(String dni) throws DataException, ServiceException {
		Connection c = null;
		AsistidoDTO asistido = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			asistido = asistidoDAO.findByDni(c, dni);
								
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
		return asistido;	
	}
	
	@Override
	public AsistidoDTO findByEmail(String email) throws DataException, ServiceException {
		Connection c = null;
		AsistidoDTO asistido = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			asistido = asistidoDAO.findByEmail(c, email);
								
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
		return asistido;	
	}
	
	@Override
	public List<AsistidoDTO> findByRuta(int idRuta) throws DataException, ServiceException {
		Connection c = null;
		List<AsistidoDTO> asistido = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			asistido = asistidoDAO.findByRuta(c, idRuta);
								
			commitOrRollback = true;
			

		} catch (SQLException sqle) {
			logger.error(idRuta, sqle);
			throw new ServiceException(idRuta+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(idRuta, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(idRuta, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		return asistido;
	}

	@Override
	public Integer create(Asistido asistido) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		Integer userId = null;
		String password =null;
		try  {
			c = ConnectionManager.getConnection();								
			
			c.setAutoCommit(false);

			if (asistidoDAO.findByEmail(c, asistido.getEmail())!=null) {
				throw new UserAlreadyExistsException(asistido.getEmail());				
			}
			
			password= PasswordEncryptionUtil.encryptPassword(asistido.getPassword());
			

			asistido.setPassword(password);
			userId = asistidoDAO.create(c, asistido);		

			mailService.sendPlain("no-reply@gmail.com", 
					"Bienvenido a AdSaude...", 
					"Hola "+asistido.getNombre()+", Bien...", 
					asistido.getEmail());
			
			commitOrRollback = true;
			
		} catch (SQLException e) {
			logger.error(asistido, e);
			throw new DataException(e);			
		} catch (ServiceException se) {
			logger.error(asistido, se);
			throw new DataException(se);	
		}finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		
		return userId;
	}

	@Override
	public void update(Asistido asistido) throws DataException, ServiceException {
		Connection c = null;
		boolean commitOrRollback = false;
		String password =null;
		try  {
			c = ConnectionManager.getConnection();					

			c.setAutoCommit(false);

			if (asistido.getPasswordEncriptada()!=null) {
				
				asistido.setPassword(asistido.getPasswordEncriptada());
			
			}else {
				
			password= PasswordEncryptionUtil.encryptPassword(asistido.getPassword());
			asistido.setPassword(password);
			}
			
			asistidoDAO.update(c, asistido);

			commitOrRollback = true;


		} catch (SQLException sqle) {
			logger.error(asistido, sqle);
			throw new ServiceException(asistido.getEmail()+"", sqle);
			
		} catch (DataException de) { // si viene del DAO ya seria innecesario
			logger.error(asistido, de);
			throw de;
			
		} catch (Exception e) {
			logger.error(asistido, e);
			throw new ServiceException(e);
			
		} finally {
			JDBCUtils.closeConnection(c, commitOrRollback);
		}
		
	}
}
