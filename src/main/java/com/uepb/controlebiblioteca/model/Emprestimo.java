package com.uepb.controlebiblioteca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.Nullable;

@Entity
@Table(name = "EMPRESTIMOS")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;

	@OneToOne(cascade = CascadeType.ALL)
	private Livro curso;

	@OneToOne(cascade = CascadeType.ALL)
	private Revista revista;

	@OneToOne(cascade = CascadeType.ALL)
	private MidiasEletronicas midiaEletronica;

	@OneToOne(cascade = CascadeType.ALL)
	private TrabalhosConclusao trabalhosConcusao;

	@OneToOne(cascade = CascadeType.ALL)
	private AnaisCongresso anaisCongresso;

	public boolean verificaPendencia() { // n implementado
		return false;

	}

}