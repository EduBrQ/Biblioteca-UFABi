package com.uepb.ControleBiblioteca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class Revistas: Atribui os diversos dados referentes aos Trabalhos de
 * Conclusao.
 * 
 * @author Lucas Nunes, Lanmark Rafael, Higor Pereira
 * 
 * @param Titulo;
 *            Edicao; Autores; Orientadores; Local; ID; Ano da Defesa; Tipo de
 *            TCC;
 * 
 * @return String table trabalhos_de_conclusao.
 */

@Entity
@Table(name = "trabalhos_de_conclusao")
public class TrabalhosDeConclusao {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	@Column(name = "ano_defesa")
	private int anoDefesa;

	@Column(name = "tipoTcc")
	private int tipoTcc;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "edicao")
	private String edicao;

	@Column(name = "autores")
	private String autores;

	@Column(name = "orientadores")
	private String orientadores;

	@Column(name = "local")
	private String local;
	
	

	public TrabalhosDeConclusao(Long id, int tipoTcc, String titulo) {
		this.id = id;
		this.tipoTcc = tipoTcc;
		this.titulo = titulo;
	}

	// CONSTRUTOR
	public TrabalhosDeConclusao() {

	}

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAnoDefesa() {
		return anoDefesa;
	}

	public void setAnoDefesa(int anoDefesa) {
		this.anoDefesa = anoDefesa;
	}

	public int getTipoTcc() {
		return tipoTcc;
	}

	public void setTipoTcc(int tipoTcc) {
		this.tipoTcc = tipoTcc;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(String orientadores) {
		this.orientadores = orientadores;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
