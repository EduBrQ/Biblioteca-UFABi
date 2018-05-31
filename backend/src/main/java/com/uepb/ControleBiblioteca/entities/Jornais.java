package com.uepb.ControleBiblioteca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class Jornais: Atribui os diversos dados referentes aos Jornais.
 * 
 * @author Lucas Nunes, Lanmark Rafael, Higor Pereira
 * 
 * @param Titulo; Edicao; Data da Publicacao; ID;
 * 
 * @return String table jornais.
 */


@Entity
@Table(name="jornais")
public class Jornais {
		
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	
	@Column(name="titulo")
	private String 	titulo;
	
	@Column(name="edicao")
	private String 	edicao;
	
	@Column(name="data_publicacao")
	private String 	dataPublicacao;
	 
	
	//CONSTRUTOR
	public Jornais() {
		
	}	
	
	//GETTERS E SETTERS
			
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}
