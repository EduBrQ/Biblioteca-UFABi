package com.lynas.dao;

import java.util.List;
import com.lynas.model.Curso;

public interface CursoDao {

	public void addCurso(Curso curso);

	public List<Curso> getAllCursos();

	public void deleteCurso(Integer cursoId);

	public Curso updateCurso(Curso curso);

	public Curso getCurso(int cursoid);
}
