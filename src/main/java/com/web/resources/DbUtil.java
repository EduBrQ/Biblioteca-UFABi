package com.web.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.model.User;

/**
 * Classe utilitaria DbUtil 
 * Responsável por auxiliar na conexão com o banco
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */

public class DbUtil {
	
	private static final Logger logger = LogManager.getLogger(DbUtil.class);

	private void runMe(String parameter) {

		if (logger.isDebugEnabled()) {
			logger.debug("This is debug : " + parameter);
		}

		if (logger.isInfoEnabled()) {
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

	}
	
	public DbUtil() {
		this.runMe("DbUtil");
	}


	private static Connection connection = null;

	/**
	 * Método responsável por adicionar uma nova conexão com o banco de dados
	 * @return
	 */
	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream("db.properties"));
				
				
				String driver = 	prop.getProperty("driver");
				String url = 		prop.getProperty("url");
				String user =  		prop.getProperty("user");
				String password = 	prop.getProperty("password");
			
				Class.forName(driver);
				
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
}