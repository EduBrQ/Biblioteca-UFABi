package com.uepb.controlebiblioteca.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import com.uepb.controlebiblioteca.model.Revista;
import com.uepb.controlebiblioteca.model.MidiasEletronicas;
import com.uepb.controlebiblioteca.model.TrabalhosConclusao;
import com.uepb.controlebiblioteca.model.AnaisCongresso;
import com.uepb.controlebiblioteca.model.Livro;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Emprestimo representa ...
 * 
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "EMPRESTIMOS")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // variavel inteira id de emprestimo.

	@Column
	private Date dataEmprestimo;
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Livro livro;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Revista revista;

	@OneToOne(cascade = CascadeType.REMOVE)
	private MidiasEletronicas midiaEletronica;

	@OneToOne(cascade = CascadeType.REMOVE)
	private TrabalhosConclusao trabalhoConclusao;

	@OneToOne(cascade = CascadeType.REMOVE)
	private AnaisCongresso analCongresso;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean verificaPendencia() { // n implementado - Bolleano para marcar se o emprestimo com entrega pendente.
		return false;

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public MidiasEletronicas getMidiaEletronica() {
		return midiaEletronica;
	}

	public void setMidiaEletronica(MidiasEletronicas midiaEletronica) {
		this.midiaEletronica = midiaEletronica;
	}

	public TrabalhosConclusao getTrabalhoConclusao() {
		return trabalhoConclusao;
	}

	public void setTrabalhoConclusao(TrabalhosConclusao trabalhoConclusao) {
		this.trabalhoConclusao = trabalhoConclusao;
	}

	public AnaisCongresso getAnalCongresso() {
		return analCongresso;
	}

	public void setAnalCongresso(AnaisCongresso analCongresso) {
		this.analCongresso = analCongresso;
	}

	
}