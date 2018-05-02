package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class UserRole implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7428336891195151331L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String roleName;

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
