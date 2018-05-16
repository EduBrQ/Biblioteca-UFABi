package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Funcionarios representa qualquer usuario do tipo funcionario cadastrado no sistema.
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // id unico do funcionario
	
	@Column
	private String nome; // nome do funcionario

	@Column
	private String senha; // senha do funcionario

	@Column(nullable = false, unique = true)
	private String cpf; // cpf do funcionario, unico e não nulo.
	
	@Column
	private String naturalidade; // naturalidade do funcionario

	@Column
	private String endereco; //  endereço do funcionario
	
	@Column(unique = true)
	private String telefone; // telefone do funcionario, único.
	
	@Column(unique = true)
	private String email; // email do funcionario, único
	
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
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