package com.web.model;

public class MidiaEletronica extends Publicacao{

	protected String tipo;

	public MidiaEletronica(String titulo, String dataPublicacao, String tipo) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.tipo = tipo;
	}
	
	/*
	 * Getters and Setters
	 * */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
}
