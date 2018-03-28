package com.web.model;

public class Publicacao {

	protected String titulo;
	protected String dataPublicacao;
	
	
	/*
	 * Getters and Setters
	 * */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getDataPublicacao() {
		return dataPublicacao;
	}
}
