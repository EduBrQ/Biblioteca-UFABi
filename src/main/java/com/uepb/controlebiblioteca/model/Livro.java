package com.uepb.controlebiblioteca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Livro representa os itens do tipo Livro que poderão ser cadastrados no sistema.
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "LIVROS")
public class Livro implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // Variavel inteira id do livro, gerando automaticamente.
	
	@Column
	private String ibs; //  Variavel string ibs do livro.

	@Column
	private String titulo; // Variavel string editora do livro.
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column
	private String editora; // Variavel string editora do livro.

	@Column
	private int edicao; // Variavel inteira edicao do livro.
	
	@Column
	private int numPaginas; // Variavel inteira número de páginas do livro.

	@Column
	private String areaConhecimento; // Variavel string area de conhecimento do livro.
	
	
	@OneToMany(mappedBy = "aluno")
	private List<Emprestimo> emprestimos;

	private String tema; // Variavel string tema do livro.


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIbs() {
		return ibs;
	}

	public void setIbs(String ibs) {
		this.ibs = ibs;
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

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
}