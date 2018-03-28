package com.web.model;


public class Administrador extends User{

	public Administrador(int id, String nome, String senha) {
		super(id, nome, senha);
		this.nivelAcesso = 1;
	}

	
}
