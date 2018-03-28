package com.web.model;

import java.util.ArrayList;

public class TrabalhoConclusao extends Impresso{

	protected ArrayList<String> orientadores;
	protected String tipo;
	protected String local;
	
	public TrabalhoConclusao(String titulo, int ano, String tipo, String local) {
		this.orientadores = new ArrayList<String>();
		this.autores = new ArrayList<String>();
		this.titulo = titulo;
		this.ano = ano;
		this.tipo = tipo;
		this.local = local;
	}
	
	public void addOrientador(String orientador) {
		
		if(!this.orientadores.contains(orientador)) {
			this.orientadores.add(orientador);
			System.out.println("Odientador "+orientador+" adicionado!");
		} else {
			System.out.println("O orientador "+orientador+" ja existe!");
		}
	}

	/*
	 * Getters and Setters
	 * */
	
	public ArrayList<String> getOrientadores() {
		return orientadores;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLocal() {
		return local;
	}
	
}
