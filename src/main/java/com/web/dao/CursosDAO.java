package com.web.dao;

import com.web.model.Curso;

public class CursosDAO {

	public Curso criarCurso(String nome, String area, String tipo) {
		return new Curso(nome, area, tipo);
	}
}
