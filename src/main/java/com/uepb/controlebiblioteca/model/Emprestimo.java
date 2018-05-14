package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESTIMOS")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String aluno_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAluno_id() {
		return aluno_id;
	}

	public void setAluno_id(String aluno_id) {
		this.aluno_id = aluno_id;
	}
	public boolean verificaPendencia() { //n implementado
		return false;
		
	}
	

}