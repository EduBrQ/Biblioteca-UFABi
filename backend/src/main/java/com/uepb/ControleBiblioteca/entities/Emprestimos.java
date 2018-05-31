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
@Table(name = "emprestimos")
public class Emprestimos {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "aluno_id")
	private int alunoId;

	@Column(name = "tipo_item")
	private int tipoItem;

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "entregue")
	private int entregue;

	@Column(name = "data_retirada")
	private String dataRetirada;

	@Column(name = "data_devolucao")
	private String dataDevolucao;

	// CONSTRUTOR
	public Emprestimos() {
	}

	// GETTERS E SETTERS
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

	public int getEntregue() {
		return entregue;
	}

	public void setEntregue(int entregue) {
		this.entregue = entregue;
	}

	public String getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
