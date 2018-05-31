package com.uepb.ControleBiblioteca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livros {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "ano_publicacao")
	private int anoPublicacao;

	@Column(name = "autores")
	private String autores;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "edicao")
	private String edicao;

	@Column(name = "ISBN")
	private String ISBN;

	@Column(name = "editora")
	private String editora;

	@Column(name = "numero_paginas")
	private int numeroPaginas;

	@Column(name = "area_conhecimento")
	private int areaConhecimento;

	@Column(name = "tipo_tema")
	private int tipoTema;

	// CONSTRUTOR
	public Livros() {

	}

	// GETTERS E SETTERS
	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public int getTipoTema() {
		return tipoTema;
	}

	public void setTipoTema(int tipoTema) {
		this.tipoTema = tipoTema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public int getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(int areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
