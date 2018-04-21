package com.web.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Classe que representa a entidade Revista 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class Revista {
	private static final Logger logger = LogManager.getLogger(Revista.class);

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
	
	public Revista() {
		this.runMe("Revista");
	}

	protected int id;
	protected String editora;
	protected int edicao;
	protected int numPaginas;
	protected String titulo;
	protected String dataPublicacao;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getDataPublicacao() {
		return dataPublicacao;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
}