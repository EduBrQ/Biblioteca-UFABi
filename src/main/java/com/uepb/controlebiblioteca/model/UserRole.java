package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * UserRole representa a definicao da role a qual o usuario pertence.
 * Define o nível de acesso do usuario.
 * @author Eduardo Borba
 *
 */
@Entity
public class UserRole implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7428336891195151331L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;// variavel inteira id da userRole.
	
    @Column(nullable = false, unique = true)
    private String roleName; // variavel string do nome da role. Não nula e Única.

    public UserRole() {
    }

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
