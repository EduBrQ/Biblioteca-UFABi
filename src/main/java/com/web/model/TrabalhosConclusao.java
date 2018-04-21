package com.web.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Classe que representa a entidade TrabalhosConclusao 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class TrabalhosConclusao {

	private static final Logger logger = LogManager.getLogger(TrabalhosConclusao.class);

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
	
	public TrabalhosConclusao() {
		this.runMe("TrabalhosConclusao");
	}
	protected int id;
	protected String tipo;
	protected String local;
	protected String titulo;
	protected String autor;
	protected String orientador;
	protected int anoDefesa;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public int getAnoDefesa() {
		return anoDefesa;
	}

	public void setAnoDefesa(int anoDefesa) {
		this.anoDefesa = anoDefesa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}	
}