package com.uepb.ControleBiblioteca.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/***
 * 
 * @author Lucas Nunes
 *
 */

@Entity
@Table(name="funcionarios",
uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf", "rg"})})
public class Funcionario {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="rg")
	private String rg ;
	
	@Column(name="naturalidade")
	private String naturalidade;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nomemae")
	private String nomemae;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="cargo")
	private String cargo;

	public Funcionario() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomemae() {
		return nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
