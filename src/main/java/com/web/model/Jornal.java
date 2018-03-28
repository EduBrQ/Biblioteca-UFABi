package com.web.model;

public class Jornal extends Publicacao{

	protected String edicao;

	public Jornal(String titulo, String dataPulicacao, String edicao) {
		this.titulo = titulo;
		this.dataPublicacao = dataPulicacao;
		this.edicao = edicao;
	}
	
	/*
	 * Getters and Setters
	 * */
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getEdicao() {
		return edicao;
	}
}
