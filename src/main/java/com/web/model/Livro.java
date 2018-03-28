package com.web.model;

import java.util.ArrayList;

public class Livro extends Impresso{

	protected String IBS;
	protected String editora;
	protected int edicao;
	protected int numPaginas;
	protected String areaConhecimento;
	protected String tema;
	
	public Livro(String titulo, int ano, String IBS, String editora, int edicao, int numPaginas, String areaConhecimento, String tema) {
		this.autores = new ArrayList<String>();
		this.titulo = titulo;
		this.ano = ano;
		this.IBS = IBS;
		this.editora = editora;
		this.edicao = edicao;
		this.numPaginas = numPaginas;
		this.areaConhecimento = areaConhecimento;
		this.tema = tema;
	}
	
	
	/*
	 * Getters and Setters
	 * */
	public String getIBS() {
		return IBS;
	}
	public void setIBS(String iBS) {
		IBS = iBS;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
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
}
