package com.web.model;


import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.resources.Ferramentas;

/**
 * Classe que representa a entidade Funcionario 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class Funcionario {
	private static final Logger logger = LogManager.getLogger(Funcionario.class);

	private void runMe(String parameter) {

		if (logger.isDebugEnabled()) {
			logger.debug("This is debug : " + parameter);
		}

		if (logger.isInfoEnabled()) {
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

	}

	public Funcionario() {
		this.runMe("Funcionario");
	}

	protected int id;
	protected String nome;
	protected String senha;
	protected String cpf;
	protected String naturalidade;
	protected String endereco;
	protected String telefone;
	protected String email;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws IOException{
		if(Ferramentas.verificaCPF(cpf)) {
			this.cpf = cpf;
			this.senha = cpf.replace("-", "").replace(".", "").substring(0, 4);
			
			
		} else {
			throw new IOException();
		}
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}