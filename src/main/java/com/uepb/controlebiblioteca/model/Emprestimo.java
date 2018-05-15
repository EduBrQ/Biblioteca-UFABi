package com.uepb.controlebiblioteca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "itens_emprestimo", joinColumns = { @JoinColumn(name = "emprestimo_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	List<ItemAcervo> projects;

	public boolean verificaPendencia() { // n implementado
		return false;

	}

}