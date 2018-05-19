package com.uepb.controlebiblioteca.model;

import java.io.Serializable;
import java.sql.Date;

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

/**
 * Reserva representa a reserva feita por um usuario ao selecionar o livro que
 * deseja separar para reserva.
 * 
 * @author Eduardo Borba
 *
 */
@Entity
@Table(name = "RESERVAS")
public class Reserva implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // variavel inteira id de emprestimo.

	@Column
	private Date dataReserva;

	
	@ManyToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;

	@OneToOne()
	private Livro livro;

	@OneToOne()
	private Revista revista;

	@OneToOne()
	private MidiasEletronicas midiaEletronica;

	@OneToOne()
	private TrabalhosConclusao trabalhoConclusao;

	@OneToOne()
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
	
	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
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