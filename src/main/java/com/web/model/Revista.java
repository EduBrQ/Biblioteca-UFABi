package com.web.model;

public class Revista extends Publicacao{

	protected String editora; 
	protected int edicao;
	protected int numPaginas;
	
	public Revista(String titulo, String dataPublicacao, String editora, int edicao, int numPaginas) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.editora = editora;
		this.edicao = edicao;
		this.numPaginas = numPaginas;
	}
	/*
	 * Getters and Setters
	 * */
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
