package com.web.model;


public class Revista {


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