package com.web.model;

import com.web.resources.Ferramentas;

public class AnaisCongresso {

	protected int id;
	protected String tipo;
	protected String nomeCongresso;
	protected String local;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
}