package com.jackrutorial.model;

import java.sql.Date;

public class Livro {
	private Integer id;
	private String isbn;
	private String titulo;
	private int autores;
	private String editora;
	private Date anoPublicacao;
	private String edicao;
	private int paginas;
	private String areaConhecimento;
	private String tema;

	public Livro() {
		super();
		
	}

	public Livro(String isbn, String titulo, int autores, String editora, Date anoPublicacao, String edicao,
			int paginas, String areaConhecimento, String tema) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autores = autores;
		this.editora = editora;
		this.anoPublicacao = anoPublicacao;
		this.edicao = edicao;
		this.paginas = paginas;
		this.areaConhecimento = areaConhecimento;
		this.tema = tema;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAutores() {
		return autores;
	}

	public void setAutores(int autores) {
		this.autores = autores;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Date getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Date anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}