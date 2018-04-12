package com.jackrutorial.model;

import java.sql.Date;

public class TrabalhoConclusao {
	private int autores;
	private String titulo;
	private int orientadores;
	private String tipo;
	private Date anoDefesa;
	
	public TrabalhoConclusao() {
		super();
	}
	
	public TrabalhoConclusao(int autores, String titulo, int orientadores, String tipo, Date anoDefesa, String local) {
		super();
		this.autores = autores;
		this.titulo = titulo;
		this.orientadores = orientadores;
		this.tipo = tipo;
		this.anoDefesa = anoDefesa;
		this.local = local;
	}
	
	public int getAutores() {
		return autores;
	}
	public void setAutores(int autores) {
		this.autores = autores;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getOrientadores() {
		return orientadores;
	}
	public void setOrientadores(int orientadores) {
		this.orientadores = orientadores;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getAnoDefesa() {
		return anoDefesa;
	}
	public void setAnoDefesa(Date anoDefesa) {
		this.anoDefesa = anoDefesa;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	private String local;

}
