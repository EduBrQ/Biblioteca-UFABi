package com.web.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.resources.Ferramentas;

/**
 * Classe que representa a entidade AnaisCongresso 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class AnaisCongresso {
	private static final Logger logger = LogManager.getLogger(AnaisCongresso.class);

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

	public AnaisCongresso() {
		this.runMe("AnaisCongresso");
	}

	protected int id;
	protected String tipo;
	protected String nomeCongresso;
	protected String local;
	
	private String[] tipos = new String[]{"artigo", "pôster","resumo"};
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if(Ferramentas.verificaTipos(tipo, this.tipos)) {
			this.tipo = tipo;
		} else {
			throw new IllegalArgumentException("Deve informar um tipo valido!");
		}
	}

	public String getNomeCongresso() {
		return nomeCongresso;
	}

	public void setNomeCongresso(String nomeCongresso) {
		this.nomeCongresso = nomeCongresso;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
}