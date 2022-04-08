package com.bruno.adsaude.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.dao.MedicoDAO;
import com.bruno.adsaude.dao.impl.MedicoDAOImpl;
import com.bruno.adsaude.dao.util.ConnectionManager;
import com.bruno.adsaude.dao.util.JDBCUtils;
import com.bruno.adsaude.exception.DataException;
import com.bruno.adsaude.exception.ServiceException;
import com.bruno.adsaude.model.MedicoDTO;
import com.bruno.adsaude.service.MedicoService;
import com.bruno.adsaude.service.util.PasswordEncryptionUtil;

public class MedicoServiceImpl implements MedicoService{

	private static Logger logger = LogManager.getLogger(MedicoServiceImpl.class);
	private MedicoDAO medicoDAO = null;
	
	public MedicoServiceImpl() {
		medicoDAO = new MedicoDAOImpl();
	}
	
	@Override
	public MedicoDTO login(String email, String password) throws DataException, ServiceException {
		Connection c = null;
		MedicoDTO medico = null;
		boolean commitOrRollback = false;
		try  {
			c = ConnectionManager.getConnection();					
			
			c.setAutoCommit(false);
			
			medico = medicoDAO.findByEmail(c, email);
			
			if (medico!=null) {
				boolean passwordOK = PasswordEncryptionUtil.checkPassword(password, medico.getPassword());
				if (!passwordOK) {
					medico = null;
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
		return medico;	
	}

}
