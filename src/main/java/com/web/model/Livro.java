package com.web.model;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.resources.Ferramentas;

/**
 * Classe que representa a entidade Livro 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class Livro {
	private static final Logger logger = LogManager.getLogger(Livro.class);

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

	protected int id;
	protected String isbn;
	protected String editora;
	protected String titulo;
	protected ArrayList<String> autores;
	protected int edicao;
	protected int anoPublicacao;
	protected int numPaginas;
	protected String areaConhecimento;
	protected String tema;
	
	public Livro() {
		this.runMe("Livro");
		autores = new ArrayList<String>();
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void addAutor(String autor) {
		this.autores.add(autor);
	}
	
	public void addAutores(String[] varios) {
		for(int i=0; i<varios.length;i++) {
			this.autores.add(varios[i]);
		}
	}
	
	public String getAutores() {
		return Ferramentas.listToStringInline(this.autores);
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
}