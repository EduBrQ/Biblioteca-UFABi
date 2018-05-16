package com.uepb.controlebiblioteca.model;

import javax.persistence.*;
import java.util.List;

@Entity
/**
 * AppUser representa qualquer instancia de usuario do sistema.
 * 
 * @author Eduardo Borba
 *
 */
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // Variável inteira de id do Usuario, é gerada automaticamente.
	
	@Column(nullable = false, unique = true)
	private String userName;  // Variável String do nome do Usuario. Obrigatoriedades:  deve ser unica e não nula.
	
	@Column(nullable = false) // Variável String de senha do Usuario, Obrigatoriedades: não nula
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<UserRole> roles; // Variavel das roles do Usuario, varios usuarios podem ter varias roles.

	public AppUser() {
	}
	
	/**
	 * Constroi e inicializa um Usuario, com os atributos - Nome, senha e role.
	 * @param userName
	 * @param password
	 * @param roles
	 */
	public AppUser(String userName, String password, List<UserRole> roles) {
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
