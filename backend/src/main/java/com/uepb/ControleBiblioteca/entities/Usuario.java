package com.uepb.ControleBiblioteca.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/***
 * 
 * @author Lucas Nunes
 *
 */

@Entity
@Table(name = "usuarios", 
uniqueConstraints = @UniqueConstraint(columnNames = {"usuario"}))
public class Usuario {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="dado_de_referencia_id")
	private int dadoDeReferenciaId;
	
	@Column(name="role")
	private int role;
	
		
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getDadoDeReferenciaId() {
		return dadoDeReferenciaId;
	}

	public void setDadoDeReferenciaId(int dadoDeReferenciaId) {
		this.dadoDeReferenciaId = dadoDeReferenciaId;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}
	


}
