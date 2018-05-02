package com.uepb.controlebiblioteca.dao;

import java.util.List;

import com.uepb.controlebiblioteca.model.Aluno;

public interface AlunoDao {

	public void addAluno(Aluno aluno);

	public List<Aluno> getAllAlunos();

	public void deleteAluno(Integer alunoId);

	public Aluno updateAluno(Aluno aluno);

	public Aluno getAluno(int alunoid);
}
