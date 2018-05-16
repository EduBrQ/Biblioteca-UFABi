package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Curso representa qualquer curso que seja cadastrado por um usuario no sistema.
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "CURSOS")
public class Curso implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // variavel inteira id do curso, gerada automaticamente.

	@Column
	private String nome; // variavel string do nome do curso

	@Column
	private String area; // variavel string atribuida a area de atuacao do curso

	@Column
	private String nivel; // variavel string atribuida ao nivel de curso

	@Column(unique = true)
	private String sigla; // variavel string atribuida a sigla unica do curso

	
	/**
	 * Este metodo retorna as duas primeiras letras da string nivel do curso. Utilizada posteriormente 
	 * para gerar parte do codigo de matricula
	 * 
	 */
	public String getLetraNivel() {

		return nivel.substring(0, 1).toUpperCase();

	}

	public String getSigla() {
		return sigla;
	}
	
	/**
	 * Metodo set de sigla, passando para UpperCase.
	 * @param sigla
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla.toUpperCase();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}