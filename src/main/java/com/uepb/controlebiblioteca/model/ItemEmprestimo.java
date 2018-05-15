package com.uepb.controlebiblioteca.model;

import java.io.Serializable;
import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ITEM_EMPRESTIMO")
public class ItemEmprestimo implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 @NotEmpty
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "ITEM_EMPRESTIMO", 
	             joinColumns = { @JoinColumn(name = "EMPRESTIMO_ID") }, 
	             inverseJoinColumns = { @JoinColumn(name = "ITEM_ID") })
	    private ArrayList<Object> itens = new ArrayList<Object>();
	 
}