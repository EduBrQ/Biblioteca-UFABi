package com.web.model;


public class Curso {

	protected int id;
	protected String nome;
	protected String area;
	protected String nivel;
	protected String sigla;
	
	private String[] niveis = new String[] {"Graduação", "Especialização","Mestrado","Doutorado"};
	/* Niveis:
	 * 0 - Graduação
	 * 1 - Especialização
	 * 2 - Mestrado
	 * 3 - Douturado
	 * */
	
	public Curso() {
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String n) {
		String nivelRes = "";
		
		
		
		if(n.length()==1) {
			n= n.toUpperCase();
			for (int i=0; i< this.niveis.length; i++) {
				if(n.equals(this.niveis[i].substring(0, 1))) {
					nivelRes = this.niveis[i];
					break;
				}
			}
		} else {
			nivelRes = n;
		}
		this.nivel = nivelRes;
	}
	
	public void setNivel(int nivel) {
		if(nivel>=0 && nivel < this.niveis.length) {
			this.nivel = niveis[nivel];
		} else {
			throw new IllegalArgumentException("Deve informar um nivel valido!");
		}
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
}
