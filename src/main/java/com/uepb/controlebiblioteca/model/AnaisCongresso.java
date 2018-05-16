package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANAIS_CONGRESSO")
/**
 * AnaisCongresso representa .
 * @author Eduardo Borba
 *
 */
public class AnaisCongresso implements Serializable {

	private static final long serialVersionUID = 2L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // Variável inteira de id de um item anaisCongresso, é gerada automaticamente.
	
	@Column
	private String tipo; // Variável String referente ao tipo de anaisCongresso.

	@Column
	private String nomeCongresso; // Variável String referente ao nome desse anaisCongresso.

	@Column
	private String local; // Variável String referente ao local de origem desse anaisCongresso.
	
	
	
	public AnaisCongresso() {
		
	}

	/**
	 * Constroi e inicializa um AnalCongresso com os atributos - id, tipo, nomeCongresso, local.
	 * @param id
	 * @param tipo
	 * @param nomeCongresso
	 * @param local
	 */
	public AnaisCongresso(int id, String tipo, String nomeCongresso, String local) {
		this.id = id;
		this.tipo = tipo;
		this.nomeCongresso = nomeCongresso;
		this.local = local;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeCongresso() {
		return nomeCongresso;
	}

	public void setNomeCongresso(String nomeCongresso) {
		this.nomeCongresso = nomeCongresso;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}