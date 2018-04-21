package com.web.model;

import com.web.resources.Ferramentas;

public class TrabalhosConclusao {

	
	protected int id;
	protected String tipo;
	protected String local;
	protected String titulo;
	protected String autor;
	protected String orientador;
	protected int anoDefesa;
	
	private String[] tipos = new String[] {"monografia", "tese", "dissertação"};
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public int getAnoDefesa() {
		return anoDefesa;
	}

	public void setAnoDefesa(int anoDefesa) {
		this.anoDefesa = anoDefesa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if(Ferramentas.verificaTipos(tipo, this.tipos)) {
			this.tipo = tipo;
		} else {
			throw new IllegalArgumentException("Deve informar um tipo valido!");
		}
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}	
}