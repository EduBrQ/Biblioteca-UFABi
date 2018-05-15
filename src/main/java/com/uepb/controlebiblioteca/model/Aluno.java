package com.uepb.controlebiblioteca.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNOS")
public class Aluno implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	public Aluno() {

	}

	public Aluno(int id, String nomeCompleto, String telefone) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nomeCompleto;

	@Column
	private String telefone;

	@Column
	private String endereco;

	@Column
	private String cpf;

	@Column
	private String rg;

	@Column
	private String nomeMae;

	@Column
	private String nomePai;

	@Column
	private String naturalidade;

	@Column
	private Date ano;

	@Column
	private String periodo;

	@Column
	private String senha;

	@Column
	private String matricula;

	@OneToOne(cascade = CascadeType.ALL)
	private Curso curso;

	@OneToMany(mappedBy = "aluno")
	private List<Emprestimo> emprestimos;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStrAno() {
		return ano.toString().substring(2, 4); // verificar
	}

	public String getIdAlunoStr() {
		if (this.getId() >= 0 && this.getId() < 10) {
			return "00" + this.getId();
		} else if (this.getId() > 9 && this.getId() < 100) {
			return "0" + this.getId();
		} else {
			return this.getId() + "";
		}
	}

	public void gerarMatricula() {
		this.matricula = this.curso.getLetraNivel() + this.curso.getSigla() + "-" + ("" + this.ano).substring(2, 4)
				+ this.periodo + getIdAlunoStr();
	}

}