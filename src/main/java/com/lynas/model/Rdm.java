package com.lynas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "RDM")
public class Rdm implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int curso_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Aluno aluno;
	
	@Column
	private String matricula;
	
	@ManyToMany
	@JoinTable(name = "RDM_CURSOS", joinColumns = @JoinColumn(name = "rdm_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
	private List<Curso> cursos;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}