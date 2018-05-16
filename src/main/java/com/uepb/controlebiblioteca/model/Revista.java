package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Revistas representa a estrutura do objeto revista 
 * que poderá ser manipulada no sistema por um usuario com autorização.
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "REVISTAS")
public class Revista implements Serializable {

	private static final long serialVersionUID = 4L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // variavel inteira id da revista.
	
	@Column
	private String editora; // variavel string da editora da revista.

	@Column
	private int edicao;// variavel inteira da edicao da revista.
	
	@Column
	private int numPaginas;// variavel inteira do numero de paginas da revista.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
}