package com.uepb.ControleBiblioteca.entities;

import java.text.DateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Revistas {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	@Column(name = "numero_paginas")
	private int numeroPaginas;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "edicao")
	private String edicao;

	@Column(name = "data_publicacao")
	private String dataPublicacao;

	@Column(name = "editora")
	private String editora;

	// CONSTRUTOR
	public Revistas() {

	}

	// GETTERS E SETTERS

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

}
