package com.jackrutorial.model;

import java.sql.Date;

public class Revista {
	private String titulo;
	private String editora;
	private Date dataPublicacao;
	private int edicao;
	private int paginas;
	
	public Revista() {
		super();
	}
	
	public Revista(String titulo, String editora, Date dataPublicacao, int edicao, int paginas) {
		super();
		this.titulo = titulo;
		this.editora = editora;
		this.dataPublicacao = dataPublicacao;
		this.edicao = edicao;
		this.paginas = paginas;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
}
