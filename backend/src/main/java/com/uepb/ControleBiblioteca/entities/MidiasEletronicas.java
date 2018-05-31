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
	private int id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "data_de_gravacao")
	private String dataDeGravacao;

	@Column(name = "tipo_de_midia")
	private int tipoMidia;

	// CONSTRUTOR
	public MidiasEletronicas() {

	}

	// GETTERS E SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(int tipoMidia) {
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
