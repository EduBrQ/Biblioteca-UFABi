package com.uepb.ControleBiblioteca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * 
 * @author Lucas Nunes
 *
 */
@Entity
@Table(name="reservas")
public class Reservas {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="aluno_id")
	private int alunoId;
	
	@Column(name="tipo_item")
	private int tipoItem;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="sinalizar")
	private int sinalizar;
	
	
	//CONTRUTOR
	public Reservas() {
	}

	
	
	//GETTERS E SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}

	public int getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(int tipoItem) {
		this.tipoItem = tipoItem;
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getSinalizar() {
		return sinalizar;
	}

	public void setSinalizar(int sinalizar) {
		this.sinalizar = sinalizar;
	}

	

}
