package com.web.dao;


import com.web.model.*;
import com.web.resources.Ferramentas;

public class UserDAO {

	
	public User criarUsuario(String nome, String senha) {
		return new User(gerarId(),nome, senha);
	}
	
	public Administrador criarAdministrador(String nome, String senha) {
		return new Administrador(gerarId(),nome, senha);
	}
	
	public int gerarId() { // Irá gerar um ID entre 1000 e 2000
		
		int id = 1000;
		id += Ferramentas.randomInt();;
		
		return id;
	}
	
}
