package com.uepb.ControleBiblioteca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "midias_eletronicas")
public class MidiasEletronicas {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "data_de_gravacao")
	private String dataDeGravacao;

	@Column(name = "tipo_de_midia")
	private String tipoMidia;

	public MidiasEletronicas(Long id, String titulo, String tipoMidia) {
		this.id = id;
		this.titulo = titulo;
		this.tipoMidia = tipoMidia;
	}

	// CONSTRUTOR
	public MidiasEletronicas() {

	}

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = tipoMidia;
	}

	public String getDataDeGravacao() {
		return dataDeGravacao;
	}

	public void setDataDeGravacao(String dataDeGravacao) {
		this.dataDeGravacao = dataDeGravacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
