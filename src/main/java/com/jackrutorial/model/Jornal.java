package com.jackrutorial.model;

public class Jornal {
	private String titulo;
	private String editora;
	private int edicao;
	
	public Jornal() {
		super();
		
	}
	public Jornal(String titulo, String editora, int edicao) {
		super();
		this.titulo = titulo;
		this.editora = editora;
		this.edicao = edicao;
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
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

}
