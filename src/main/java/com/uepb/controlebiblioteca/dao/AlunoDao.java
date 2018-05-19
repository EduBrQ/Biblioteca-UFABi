package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.Aluno;

/**
 * Interface que define os metodos que podem ser utilizados implementando a mesma.
 * @author Eduardo Borba
 *
 */
public interface AlunoDao {

	public void addAluno(Aluno aluno);

	public List<Aluno> getAllAlunos();

	public void deleteAluno(Integer alunoId);

	public Aluno updateAluno(Aluno aluno);

	public Aluno getAluno(int alunoid);
}
