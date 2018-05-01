package com.lynas.service;

import java.util.List;

import com.lynas.model.Curso;

public interface CursoService {
	
	public void addCurso(Curso curso);

	public List<Curso> getAllCursos();

	public void deleteCurso(Integer cursoId);

	public Curso getCurso(int cursoid);

	public Curso updateCurso(Curso curso);
}
