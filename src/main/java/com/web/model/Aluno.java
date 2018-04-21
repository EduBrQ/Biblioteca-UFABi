	package com.web.model;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.web.resources.Ferramentas;

/**
 * Classe que representa a entidade Aluno 
 * Onde é efetuada toda a lógica de negócio
 * 
 * @author Aleksandro, Eduardo e Thiago
 *
 */
public class Aluno {
	
	private static final Logger logger = LogManager.getLogger(Aluno.class);

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

	protected int id;
	protected String nomeCompleto;
	protected String telefone;
	protected String endereco;
	protected String cpf;
	protected String rg;
	protected String nomeMae;
	protected String nomePai;
	protected String naturalidade;
	
	public Aluno() {
		this.runMe("Aluno");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf){
		if(Ferramentas.verificaCPF(cpf)) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("Deve informar um cpf valido!");
		}
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	

}
