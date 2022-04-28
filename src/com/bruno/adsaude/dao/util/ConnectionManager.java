package com.bruno.adsaude.dao.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bruno.adsaude.service.util.ConfigurationManager;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionManager {
	
	private static final String DB_PFX = "db."; 
	private static final String URL_PARAMETER_NAME = DB_PFX + "url";
	private static final String USER_PARAMETER_NAME = DB_PFX + "user";
	private static final String PASSWORD_PARAMETER_NAME = DB_PFX + "password";
	private static final String DRIVER_PARAMETER_NAME = DB_PFX + "driver";
	private static Logger logger = LogManager.getLogger(ConnectionManager.class);
	
	private static String DRIVER_CLASS = null;
	private static String DB_URL = null;
	private static String DB_USER = null;
	private static String DB_PASSWORD = null;
	private static ComboPooledDataSource dataSource = null;
	
	static {
		DRIVER_CLASS = ConfigurationManager.getInstance().getParameter(DRIVER_PARAMETER_NAME);
		DB_URL = ConfigurationManager.getInstance().getParameter(URL_PARAMETER_NAME);
		DB_USER =ConfigurationManager.getInstance().getParameter(USER_PARAMETER_NAME);
		DB_PASSWORD = ConfigurationManager.getInstance().getParameter(PASSWORD_PARAMETER_NAME);
		try {

			Class.forName(DRIVER_CLASS);

			dataSource = new ComboPooledDataSource(); // crates the connection pool
			dataSource.setDriverClass(DRIVER_CLASS);
			dataSource.setJdbcUrl(DB_URL);
			dataSource.setUser(DB_USER);
			dataSource.setPassword(DB_PASSWORD);

		} catch (Throwable t) {
			logger.fatal("Unable to load db driver class: "+DRIVER_CLASS);
			System.exit(0);
		}

	}
	
	
	
	
	public static Connection getConnection() throws SQLException {
		
        try {

        	Connection con = dataSource.getConnection(); 
            return con;
        }  catch (SQLException sqle) {
			logger.fatal(sqle);
			throw sqle;
		}
    }

}
