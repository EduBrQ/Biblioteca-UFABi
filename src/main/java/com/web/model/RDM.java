package com.web.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RDM {
	
	String matricula;
	String senha;
	int ano;
	int periodo;
	
	private int idAluno;
	private int idCurso;
	
	public RDM() {
		// No momento que ele cria o rdm, ele faz a matricula do aluno, então é chamado o alunoDAO pra criar um novo
	}
	
	
	public String gerarMatricula() {
		String resultado = "";
		
		return resultado;
	}

}
