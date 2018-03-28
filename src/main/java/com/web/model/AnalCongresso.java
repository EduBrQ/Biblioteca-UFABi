package com.web.model;

import java.util.ArrayList;

public class AnalCongresso extends Impresso{
	protected String tipo;
	protected String nomeCongresso;
	protected String local;
	
	public AnalCongresso(String titulo, int ano,String tipo, String nomeCongresso, String local) {
		this.autores = new ArrayList<String>();
		this.local = local;
		this.nomeCongresso = nomeCongresso;
		this.tipo = tipo;
		this.titulo = titulo;
		this.ano = ano;
		
	}
	
	/*
	 * Getters and Setters
	 * */
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNomeCongresso() {
		return nomeCongresso;
	}
	public void setNomeCongresso(String nomeCongresso) {
		this.nomeCongresso = nomeCongresso;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLocal() {
		return local;
	}
}
