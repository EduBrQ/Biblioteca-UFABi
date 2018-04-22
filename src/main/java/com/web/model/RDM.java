package com.web.model;


public class RDM {
	
	protected int id;
	protected String matricula;
	protected String senha;
	protected int ano;
	protected int periodo;
	
	private int gambiarraCont; // Serve para gerar a matricula assim que preencher todos os campos de rdm
	private int gambiarraContMax = 4;
	private boolean gambiarraTrava = false;
	
	protected Aluno aluno;
	protected Curso curso;
	
	public RDM() {
		aluno = new Aluno();
		curso = new Curso();
	}
	
	public void gerarMatricula() {
		
		this.matricula = this.curso.getLetraNivel() + 
						 this.curso.getSigla() + "-" +
						 (""+this.ano).substring(2, 4) +
						 this.periodo +
						 getIdAlunoStr();
		
		this.senha = this.aluno.getCpf().replace("-", "").replace(".", "").substring(0, 4);
		
	}
	
	
	
	public String getIdAlunoStr() {
		if(aluno.getId() >= 0 && aluno.getId() < 10) {
			return "00" + aluno.getId();
		} else if (aluno.getId() > 9 && aluno.getId() < 100) {
			return "0" + aluno.getId();
		} else {
			return aluno.getId()+"";
		}
	}
	
	
	public void gambiarraConta() {
		if(gambiarraTrava) {
			gerarMatricula();
		} else {
			gambiarraCont+=1;
			if(gambiarraCont == gambiarraContMax) {
				gerarMatricula();
				gambiarraTrava = true;
			}
		}
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		
		gambiarraConta();
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
		
		gambiarraConta();
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
		
		gambiarraConta();
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
		
		gambiarraConta();
	}
	
	public int getPeriodo() {
		return periodo;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}
	
	

}
