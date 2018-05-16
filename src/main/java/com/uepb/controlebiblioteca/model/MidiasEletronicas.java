package com.uepb.controlebiblioteca.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MidiasEletronicas representa uma generalizacao dos diferentes
 * tipos de midias eletronicas, a variavel 'tipo' define essa caracteristica.
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "MIDIAS_ELETRONICAS")
public class MidiasEletronicas implements Serializable {

	private static final long serialVersionUID = 3L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // variavel inteira id da midia eletronica, gerado automaticamente.
	
	@Column
	private String tipo; // variavel string do tipo da midia eletronica, DVD, CD, etc.

	@Column
	private String titulo; // variavel string do titulo da midia eletronica.

	@Column
	private Date dataGravacao; // variavel Date da midia eletronica, diz respeito a data em que a midia foi gravada.  
	
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}
}