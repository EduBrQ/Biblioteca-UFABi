package com.web.model;

import java.util.ArrayList;

import com.web.resources.Ferramentas;

public class Livro {

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
	
	public String getArrayAutores() {
		return Ferramentas.listToString(this.autores);
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