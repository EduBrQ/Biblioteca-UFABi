package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reserva representa a reserva feita por um usuario ao selecionar o livro que deseja separar para reserva.
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "EMPRESTIMOS")
public class Reserva implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // variavel inteira do id da reserva, gerada automaticamente
	
	@Column
	private String aluno_id; // variavel inteira id do aluno que iniciou a reserva.

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

}