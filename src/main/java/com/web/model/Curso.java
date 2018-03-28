package com.web.model;

public class Curso {

	protected String nome;
	protected String area;
	protected String tipo; // Graduação ou pós
	
	public Curso(String nome, String area, String tipo) {
		this.nome = nome;
		this.area = area;
		this.tipo = tipo;
	}
	/*
	 * Getters and Setters
	 * */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
