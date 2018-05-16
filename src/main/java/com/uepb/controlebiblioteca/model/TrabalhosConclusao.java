package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TrabalhosConclusao representa a estrutura do objeto trabalho de conclusao 
 * que poderá ser manipulada no sistema por um usuario com autorização.
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "TRABALHOS_CONCLUSAO")
public class TrabalhosConclusao implements Serializable {

	private static final long serialVersionUID = 5L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // variavel inteira id do trabalho de conclusao.
	
	@Column
	private String tipo;  // variavel string tipo do trabalho de conclusao.

	@Column
	private String local;
	
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}	
}