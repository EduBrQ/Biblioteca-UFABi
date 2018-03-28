package com.web.model;



public class User {

	/*
	 * Níveis de acesso:
	 * 0 - root
	 * 1 - admin
	 * 2 - usuário normal ou funcionário
	 * */
	protected int nivelAcesso;
	protected int id; // Será gerado um ID automático diferente dos que não existem
	protected String nome;
	protected String senha;
	
	public User(int id, String nome, String senha) {
		this.nivelAcesso = 2;
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}

	/*
	 * Getters and Setters
	 * */
	public int getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
