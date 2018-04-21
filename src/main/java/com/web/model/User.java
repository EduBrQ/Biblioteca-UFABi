package com.web.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Classe que representa a entidade User Onde é efetuada toda a lógica de
 * negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class User {
	
	private static final Logger logger = LogManager.getLogger(User.class);

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

	private int id;
	private String firstname;
	private String lastname;
	private String address;
	private int nivelAcesso;

	/*
	 * Niveis de acesso: 0 - root 1 - admin 2 - usuario normal 3 - outros
	 */
	public User() {
		this.runMe("User");
		this.setNivelAcesso(2);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return this.getFirstname() + " " + this.getLastname();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}
}
