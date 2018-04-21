package com.web.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.dao.TrabalhoConclusaoDAO;

/**
 * Classe que representa a entidade Administrador 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class Administrador extends User{

	private static final Logger logger = LogManager.getLogger(Administrador.class);

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

	
	/**
	 * Cria um Administrador com o nível de acesso 1(admin)
	 */
	public Administrador() {
		this.runMe("Administrador");
		this.setNivelAcesso(1);
	}
	
}
