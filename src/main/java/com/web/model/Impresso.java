package com.web.model;

import java.util.ArrayList;

public class Impresso {

	protected String titulo;
	protected ArrayList<String> autores;
	protected int ano; //Ano de publicação ou ano de defesa
	
	public void addAutor(String autor) {
						
		if(!this.autores.contains(autor)) {
			autores.add(autor);
			System.out.println("Autor "+autor+" adicionado!");
		} else {
			System.out.println("Autor "+autor+" ja existe!");
		}
	}

	/*
	 * Getters and Setters
	 * */
	
	public ArrayList<String> getAutores() {
		return autores;
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
