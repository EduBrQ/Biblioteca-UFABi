package com.lynas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "RDM_CURSOS")
public class RdmCursos implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int rdm_id;

	@Column
	private int curso_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRdm_id() {
		return rdm_id;
	}

	public void setRdm_id(int rdm_id) {
		this.rdm_id = rdm_id;
	}

	public int getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}
}