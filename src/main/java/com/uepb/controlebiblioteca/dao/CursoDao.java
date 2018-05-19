package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.Curso;

/**
 * Interface que define os metodos que podem ser utilizados implementando a mesma.
 * @author Eduardo Borba
 *
 */
public interface CursoDao {

	public void addCurso(Curso curso);

	public List<Curso> getAllCursos();

	public void deleteCurso(Integer cursoId);

	public Curso updateCurso(Curso curso);

	public Curso getCurso(int cursoid);
}
