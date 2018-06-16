package com.uepb.ControleBiblioteca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	@Column(name = "matricula")
	private String matricula;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "naturalidade")
	private String naturalidade;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nomemae")
	private String nomemae;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "curso")
	private String curso;

	@Column(name = "ano")
	private String ano;

	@Column(name = "periodo")
	private String periodo;

	@Column(name = "nivel")
	private String nivel;

	@Column(name = "email")
	private String email;

	/***
	 * Construtor da classe Aluno
	 * 
	 * @param matricula
	 *            �nica para cada aluno
	 * @param cpf
	 *            N�mero pessoa f�sica
	 * @param rg
	 *            Registro de pessoa f�sica
	 * @param naturalidade
	 *            Cidade onde nasceu
	 * @param nome
	 *            Nome completo
	 * @param nomemae
	 *            Nome completo da m�e do aluno
	 * @param endereco
	 *            Endere�o completo
	 * @param telefone
	 *            Telefone do aluno
	 * @param curso
	 *            Curso escolhido
	 * @param ano
	 *            Ano em que est� cursando
	 * @param periodo
	 *            Periodo que est� estudando
	 * @param senha
	 *            Senha para acessar o sistema
	 * @param nivel
	 *            Nivel de estudo sendo Gradua��o, Mestrado, Especializa��o
	 *            e Doutorado.
	 */
	
	public Aluno() {

	}

	public Aluno(Long id, String matricula, String cpf, String nome) {
		this.id = id;
		this.matricula = matricula;
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getNomemae() {
		return nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
