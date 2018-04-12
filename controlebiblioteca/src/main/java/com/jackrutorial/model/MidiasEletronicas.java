package com.jackrutorial.model;

import java.sql.Date;

import com.mysql.fabric.xmlrpc.base.Array;

public class MidiasEletronicas {
	
	private String titulo;
	private Array tipo;
	private Date dataGravacao;
	
	public MidiasEletronicas() {
		super();
	}
	
	public MidiasEletronicas(String titulo, Array tipo, Date dataGravacao) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.dataGravacao = dataGravacao;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Array getTipo() {
		return tipo;
	}
	public void setTipo(Array tipo) {
		this.tipo = tipo;
	}
	public Date getDataGravacao() {
		return dataGravacao;
	}
	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}
	
}
