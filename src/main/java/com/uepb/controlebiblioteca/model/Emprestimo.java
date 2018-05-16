package com.uepb.controlebiblioteca.model;

import java.io.Serializable;

<<<<<<< HEAD
import javax.persistence.CascadeType;
=======
>>>>>>> d798c7c1d4a0418508ca923720a2609b1fb57175
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.Nullable;

=======
import javax.persistence.Table;

/**
 * Emprestimo representa ...
 * @author Eduardo Borba
 *
 */
>>>>>>> d798c7c1d4a0418508ca923720a2609b1fb57175
@Entity
@Table(name = "EMPRESTIMOS")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // variavel inteira id de emprestimo.
	
	@Column
	private int aluno_id; // id do aluno que realizou o emprestimo.
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

<<<<<<< HEAD
	@OneToOne(cascade = CascadeType.ALL)
	private Livro curso;

	@OneToOne(cascade = CascadeType.ALL)
	private Revista revista;

	@OneToOne(cascade = CascadeType.ALL)
	private MidiasEletronicas midiaEletronica;

	@OneToOne(cascade = CascadeType.ALL)
	private TrabalhosConclusao trabalhosConcusao;

	@OneToOne(cascade = CascadeType.ALL)
	private AnaisCongresso anaisCongresso;
=======
	public int getAluno_id() {
		return aluno_id;
	}
>>>>>>> d798c7c1d4a0418508ca923720a2609b1fb57175

	public void setAluno_id(int aluno_id) {
		this.aluno_id = aluno_id;
	}
	public boolean verificaPendencia() { //n implementado - Bolleano para marcar se o emprestimo com entrega pendente.
		return false;
		
	}
	

}